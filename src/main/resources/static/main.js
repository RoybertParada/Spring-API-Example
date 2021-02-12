$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8090/api/courses/all"
    }).then(function(data) {
        appendData(data);
    });
});

function appendData(data) {
    var accordionExample = document.getElementById("accordionExample");
    for(var i = 0; i < data.length; i++){
        var accordionItem = document.createElement("div");

        var h2 = '<h2 class="accordion-header" id="heading_'+data[i].courseId+'"><button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse_'+data[i].courseId+'" aria-expanded="true" aria-controls="collapse_'+data[i].courseId+'">'+data[i].name+'</button></h2>'
        accordionItem.innerHTML = h2;
        accordionItem.className = 'accordion-item';

        var collapse = document.createElement("div");
        collapse.id='collapse_'+data[i].courseId;
        collapse.className='accordion-collapse collapse'
        collapse.setAttribute("aria-labelledby",'heading_'+data[i].courseId);
        collapse.setAttribute("data-bs-parent","#accordionExample");
        
        var accordionBody = document.createElement("div");
        accordionBody.className="accordion-body";

        var table = document.createElement("table");
        table.className="table";
        table.id='table_'+data[i].courseId;
        var thead = document.createElement("thead");
        thead.innerHTML = '<tr><th scope="col">#</th><th scope="col">Nombre</th><th scope="col">Periodo</th><th scope="col">Año</th><th scope="col">Acciones</th></tr>'
        
        table.appendChild(thead);
        appendInstructors(data[i].courseId);    
        accordionBody.appendChild(table);
        collapse.appendChild(accordionBody)        
        accordionItem.appendChild(collapse);
        accordionExample.appendChild(accordionItem);   
    }
}

function appendInstructors(courseId){    
    var instructors;
    $(document).ready(function() {
        $.ajax({
            url: 'http://localhost:8090/api/courses/instructors/'+courseId
        }).then(function(data) {
            var table = document.getElementById("table_"+courseId);
            var tbody = document.createElement("tbody"); 
            tbody.id = "tbody_"+courseId;
            var tr = appendInstructor(data);
            tbody.innerHTML=tr;
            table.appendChild(tbody);
            getAllInstructor(courseId);
        });
    });  
    return instructors;
}

function appendInstructor(data){
    var tr='';   
    for(var j = 0; j < data[0].instructors.length; j++){
        tr = tr+'<tr id=tr_'+data[0].courseId+'_'+data[0].instructors[j].instructorId+' ><th scope="row">'+data[0].instructors[j].instructorId+'</th><td>'+data[0].instructors[j].name+'</td><td>'+data[0].instructors[j].periodId+'</td><td>'+data[0].instructors[j].year+'</td><td><button class="btn btn-danger" type="button" data-id="button_'+data[0].courseId+'_'+data[0].instructors[j].instructorId+'"  onClick="onClickDeleteButton(this)"><i class="fa fa-trash"></i> Eliminar</button></td></tr>'
    }
    return tr;
}


function onClickDeleteButton(identifier){
    var data_id= $(identifier).data('id');
    var id = data_id.substring(data_id.indexOf("_")+1,data_id.indexOf("_").length);
    var courseid = data_id.substring(data_id.indexOf("_")+1,data_id.indexOf("_")+2);
    let instructorData = document.getElementById("tr_"+id).childNodes;
    let deletePK = {
        "cursoId": courseid,
        "instructorId": instructorData[0].outerText,
        "periodoId": instructorData[2].outerText,
        "year": instructorData[3].outerText
    }
    deleteInstructor(JSON.stringify(deletePK),id);
    
}

function deleteInstructor(periodId,id){
    return fetch('http://localhost:8090/api/period/delete', {
        method: 'DELETE',
        headers: {'Content-type': 'application/json; charset=UTF-8'},
        body: periodId,
    }).then(function(response) {
        if(response.status==200){
            document.getElementById("tr_"+id).remove();
        }else{
            alert("Ha ocurrido un error al eliminar el Instructor")
        }
    })
}

function getAllInstructor(courseId){
    return fetch('http://localhost:8090/api/instructors/all')
    .then(response => response.json())
    .then(data => {
        var options='';
        for(var j = 0; j < data.length; j++){
            options = options+'<option value="'+j+'">'+data[j].instructorId+'. '+data[j].name+'</option>'
        }
        var tr = '<th scope=row></th><td><div class="input-group mb-3"><select class="form-select" id="inputGroupSelect_Instructor_'+courseId+'"><option selected>Selecciona un Instructor</option>'+options+'</select></div></td><td><div class="input-group mb-3"><select class="form-select" id="inputGroupSelect_Periodo_'+courseId+'"><option selected>Selecciona un Periodo</option><option value="1">Q1</option><option value="2">Q2</option><option value="3">Q3</option><option value="4">Q4</option></select></div></td><td><div class="input-group mb-3"><select class="form-select" id="inputGroupSelect_Año_'+courseId+'"><option selected>Selecciona un Año</option><option value="1">2021</option><option value="2">2022</option><option value="3">2023</option><option value="4">2024</option></select></div></td><td><button class="btn btn-success" type="button" data-id="button_'+courseId+'_addButton" onClick="onClickAddButton(this)"><i class="fa fa-plus"></i> Agregar</button></td>' 
        
        var tbody = document.getElementById("tbody_"+courseId);
        var trElement = document.createElement("tr"); 
        trElement.id = 'tr_'+courseId+'_dropdowninstructors';
        trElement.innerHTML = tr;
        tbody.appendChild(trElement);
    })
}


function onClickAddButton(identifier){
    var data_id= $(identifier).data('id');
    var id = data_id.substring(data_id.indexOf("_")+1,data_id.indexOf("_").length);
    var courseid = data_id.substring(data_id.indexOf("_")+1,data_id.indexOf("_")+2);
    let instructorData = document.getElementById("tr_"+courseid+'_dropdowninstructors').childNodes;    
    var dropdownInstructors = document.getElementById("inputGroupSelect_Instructor_"+courseid);
    var instructorDataId = dropdownInstructors.options[dropdownInstructors.selectedIndex].text;
    var idInstructor = instructorDataId.substring(0,instructorDataId.indexOf("."));
    var dropdownPeriodo = document.getElementById("inputGroupSelect_Periodo_"+courseid);
    var periodoId = dropdownPeriodo.options[dropdownPeriodo.selectedIndex].text;
    var dropdownAño = document.getElementById("inputGroupSelect_Año_"+courseid);
    var año = dropdownAño.options[dropdownAño.selectedIndex].text;
    var inicio;
    var fin;

    if(periodoId=="Q4"){
        inicio = año+"-10-01T00:00:00";
        fin = año+"-12-31T00:00:00";
    }else if(periodoId=="Q3"){
        inicio = año+"-07-01T00:00:00";
        fin = año+"-09-30T00:00:00";
    }else if(periodoId=="Q2"){
        inicio = año+"-04-01T00:00:00";
        fin = año+"-06-30T00:00:00";
    }else if(periodoId=="Q1"){
        inicio = año+"-01-01T00:00:00";
        fin = año+"-03-30T00:00:00";
    }

    let addPeriod = {
        "periodId": periodoId,
        "year": año,
        "inicio": inicio,
        "fin": fin,
        "instructor": {
            "instructorId": idInstructor
        },
        "curso": {
            "courseId": courseid
        }
    }
    addInstructor(JSON.stringify(addPeriod),id);
}

function addInstructor(periodId,id){
    return fetch('http://localhost:8090/api/period/save', {
        method: 'POST',
        headers: {'Content-type': 'application/json; charset=UTF-8'},
        body: periodId,
    }).then(function(response) {
        if(response.status==201){
            alert("Ha agregado al instructor exitosamente")
            location.reload()
        }else{
            alert("Ha ocurrido un error al eliminar el Instructor")
        }
    })
}