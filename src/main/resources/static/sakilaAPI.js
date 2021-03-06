
function getAll(){
    let xhttp = new XMLHttpRequest();
    let url = "http://192.168.1.116:8080/api/film_list";
    let film_table = document.createElement("TABLE");
    let table_body = document.createElement("TBODY");
    xhttp.onreadystatechange = function (){
        if (xhttp.readyState == 4 && xhttp.status == 200){
            let film_list = JSON.parse(xhttp.responseText);
            
            for(let i in film_list){
                let row = document.createElement("TR");
                // title column //
                let title_cell = document.createElement("TD");
                let title_cell_text = document.createTextNode( JSON.stringify(film_list[i].title));
                title_cell.appendChild(title_cell_text);
                row.appendChild(title_cell);

                // description column //
                let desc_cell = document.createElement("TD");
                let desc_cell_text = document.createTextNode(JSON.stringify(film_list[i].description));
                desc_cell.appendChild(desc_cell_text);
                row.appendChild(desc_cell);

                 //category //
                let cat_cell = document.createElement("TD");
                let cat_cell_text = document.createTextNode(JSON.stringify(film_list[i].category));
                cat_cell.appendChild(cat_cell_text);
                row.appendChild(cat_cell);

                //append this row to table// 
                table_body.appendChild(row);

            }

        }
    }      
 
    
    xhttp.open("GET", url,true);

    xhttp.send();
    film_table.appendChild(table_body);
    document.getElementById("filmlist").appendChild(film_table);
   
} 
  

function getFilmByID(){
    // document.getElementById("film_list").removeChild(document.getElementById("film_list").lastChild);
    let filmID = document.getElementById("inputFID").value;
    let xhttp = new XMLHttpRequest();
    let url = "http://192.168.1.116:8080/api/film_list/" + filmID;
    let film_table = document.createElement("TABLE");
    let table_body = document.createElement("TBODY");
    
    xhttp.onreadystatechange = function (){
        if (xhttp.readyState == 4 && xhttp.status == 200){

            let film_list = JSON.parse(xhttp.responseText);
            let search_result = document.createTextNode(JSON.stringify(film_list.title));

            let row = document.createElement("TR");
            let title_cell = document.createElement("TD");
            let title_cell_text = document.createTextNode( JSON.stringify(film_list.title));
             title_cell.appendChild(title_cell_text);
            row.appendChild(title_cell);
            table_body.appendChild(row);

        }
    }
    xhttp.open("GET", url,true);
    xhttp.send();
    film_table.appendChild(table_body);
    document.getElementById("filmlist").appendChild(film_table);
    
}

let film_array = [];

function storeFilms(){
    
    let xhttp = new XMLHttpRequest();
    let url = "http://192.168.1.116:8080/api/film_list";
    xhttp.onreadystatechange = function (){
        if (xhttp.readyState == 4 && xhttp.status == 200){
            console.log("ready");
            let film_list = JSON.parse(xhttp.responseText);
            for(let i in film_list){
                film_array.push(film_list[i]);
                
            }
        }
           
    }
    xhttp.open("GET", url,true);
    xhttp.send();
   

}

function findByCat(){
    let film_cat = document.getElementById("inputCAT").value;
    let film_table = document.createElement("TABLE");
    let table_body = document.createElement("TBODY");
    // let filtered_films = film_array.filter((film)=>film.category == film_cat);
    let filtered_films = [];
    for(let i = 0; i< film_array.length; i++){
        if(film_array[i].category === film_cat){
            filtered_films.push(film_array[i]);
    
        }
    }
    for(let i in filtered_films){
                let row = document.createElement("TR");
                // title column //
                let title_cell = document.createElement("TD");
                let title_cell_text = document.createTextNode( JSON.stringify(filtered_films[i].title));
                title_cell.appendChild(title_cell_text);
                row.appendChild(title_cell);

                // description column //
                let desc_cell = document.createElement("TD");
                let desc_cell_text = document.createTextNode(JSON.stringify(filtered_films[i].description));
                desc_cell.appendChild(desc_cell_text);
                row.appendChild(desc_cell);

                 //category //
                let cat_cell = document.createElement("TD");
                let cat_cell_text = document.createTextNode(JSON.stringify(filtered_films[i].category));
                cat_cell.appendChild(cat_cell_text);
                row.appendChild(cat_cell);

                //append this row to table// 
                table_body.appendChild(row);



        }
    film_table.appendChild(table_body);
    document.getElementById("filmlist").appendChild(film_table);
}

 function clearSearch(){
     let film_list_node = document.getElementById("filmlist");
     let first_node = film_list_node.firstChild;
     console.log(film_list_node.childNodes.length);
     while ( first_node){
         film_list_node.removeChild(first_node);
         first_node = film_list_node.firstChild;
     }
     
 }

   


