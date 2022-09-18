


function validator() {

    var user=document.getElementById("user")
    var password=document.getElementById("password")
    var phonenumber=document.getElementById("phone");
    var reg=/^[A-Z a-z0-9]+$/g
    var reg1=/^[0-9]+$/g
  

    if (user.value.length<6) {
  
    swal("Sorry","UserName Should Must Contain More Then 6 Characters ","error");
  return false
  
  }  
  else if (user.value.length>10) {
  
    swal("Sorry","UserName Should Must Contain Less Then 1- Characters ","error");
  return false
  
  }
  else if (password.value.length<6) {
  
    swal("Sorry","Password Should Must Contain More Then 6 Characters ","error");
  return false
  } 
  
  else if (password.value.length>10) {
  
    swal("Sorry","Password Should Must Contain Less Then 10 Characters ","error");
  return false
  } 
  else if (phonenumber.value.length<10) {
  
    swal("Sorry","PhoneNumber Should Must Contain Only 10 Digits ","error");
  return false
  
  } 
  else if (phonenumber.value.length>10) {
  
    swal("Sorry","PhoneNumber Should Must Contain Only 10 Digits ","error");
  return false
  }
  else if (reg1.test(phonenumber.value)==false) {
  
    swal("Sorry","PhoneNumber Should Must Contain Only  Digits ","error");
  
  return false
  }
  
  else{

   return true;
      
  }
  
  }