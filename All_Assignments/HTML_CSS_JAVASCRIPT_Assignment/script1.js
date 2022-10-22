//For storing and retrieving values from the html table using localStorage in Javascript
let id="no";

selectData();
function manageData(){
	
	let name=document.getElementById('name').value;

    var gen;
    var type=document.getElementsByName("gender");
    if(type[0].checked){
        gen=type[0].value;
    }
    else if(type[1].checked){
        gen=type[1].value;
    }
    
    let mail=document.getElementById('email').value;
    let web=document.getElementById('website').value;
    var skills="";
    if(document.getElementById("java").checked==true){
       skills=skills+" "+document.getElementById("java").value;
    }
    if(document.getElementById("html").checked==true){
         skills=skills+" "+document.getElementById("html").value;
    }
    if(document.getElementById("css").checked==true){
            skills=skills+" "+document.getElementById("css").value;
    }
    let imglink=document.getElementById('imagelink').value;
    
		if(id=='no'){
			let arr=getCrudData();
			if(arr==null){
				let data1=[name];
                let data4=[gen];
                let data2=[mail];
                let data3=[web];
                let data5=[skills];
                let data6=[imglink];
                
				setCrudData(data1);
                setCrudData(data4);
                setCrudData(data2);
                setCrudData(data3);
                setCrudData(data5);
                setCrudData(data6);
                
			}else{
				arr.push(name);
                arr.push(gen);
                arr.push(mail);
                arr.push(web);
                arr.push(skills);
                arr.push(imglink);
				setCrudData(arr);
                
			}
			
		}
        else{
			let arr=getCrudData();
			arr[id]=name;
            arr[id]=gen;
            arr[id]=mail;
            arr[id]=web;
            arr[id]=skills;
            arr[id]=imglink;
			setCrudData(arr);
			
		}
		document.getElementById('name').value='';
        document.getElementsByName('gender').value='';
        document.getElementById('email').value='';
        document.getElementById('website').value='';
        document.getElementsByName('skills').value='';
        document.getElementById('imagelink').value='';
		selectData();
	}


    function selectData(){
        let arr=getCrudData();
        if(arr!=null){
            let html='';
            
            for(let k in arr){
                html=html+`<tr><td>${arr[k]}</td><td><a href="javascript:void(0)" onclick="deleteData(${k})">Delete</a></td></tr>`;
                
            }
            document.getElementById('root').innerHTML=html;
            
        }
    }

function deleteData(rid){
	let arr=getCrudData();
	arr.splice(rid,1);
	setCrudData(arr);
	selectData();
}

function getCrudData(){
	let arr=JSON.parse(localStorage.getItem('crud'));
	return arr;
}

function setCrudData(arr){
	localStorage.setItem('crud',JSON.stringify(arr));
}

//***********************************************************************************************/
//Validation of the form using javascript regular expressions
function validate_name(id){
    var ele=document.getElementById(id);
    var regx1=/^[a-zA-Z ]+$/;
    
    if(!regx1.test(ele.value)){
        alert("Enter Valid Name!");
        ele.style.border="2px solid red";
        return false;
    }
    ele.style.border="2px solid green";   
}
    function validate_email(id){
      var ele=document.getElementById(id);
      var regx1=/^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+).([a-z]{2,20})(.[a-z]{2,8})?$/;
      
      if(!regx1.test(ele.value)){
          alert("Enter Valid EmailID!");
          ele.style.border="2px solid red";
          return false;
      }
      ele.style.border="2px solid green";   
}
  function validate_website(id){
      var ele=document.getElementById(id);
      var regx1=/(?:https?):\/\/(\w+:?\w*)?(\S+)(:\d+)?(\/|\/([\w#!:.?+=&%!\-\/]))?/;
      
      if(!regx1.test(ele.value)){
          alert("Enter Valid Website!");
          ele.style.border="2px solid red";
          return false;
      }
      ele.style.border="2px solid green";   
}
  function validate_imagelink(id){
      var ele=document.getElementById(id);
      var regx1=/(?:https?):\/\/(\w+:?\w*)?(\S+)(:\d+)?(\/|\/([\w#!:.?+=&%!\-\/]))?/;
      
      if(!regx1.test(ele.value)){
          alert("Enter Valid URL!");
          ele.style.border="2px solid red";
          return false;
      }
      ele.style.border="2px solid green";
      
        
}