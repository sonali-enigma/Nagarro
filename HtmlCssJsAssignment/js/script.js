function SubmitForm() {
  if (validateForm()) {
    saveData();
    return true;
  }
  else {
    return false;
  }
}

function saveData() {

  let name, email, website, imglink, gender;
  name = document.getElementById("Name").value;
  email = document.getElementById("Email").value;
  website = document.getElementById("Website").value;
  imglink = document.getElementById("ImageLink").value;
  var male = document.getElementById("MaleGender");
  if (male.checked == true) {
    gender = "Male";
  }
  else
    gender = "Female";

  var java = document.getElementById("Java");
  var html = document.getElementById("HTML");
  var css = document.getElementById("CSS");

  var skills = "";
  if (java.checked == true)
    skills = skills + "Java";
  if (css.checked == true) {
    if (skills.length > 2)
      skills = skills + ",CSS";
    else
      skills = skills + "CSS";
  }
  if (html.checked == true) {
    if (skills.length > 2)
      skills = skills + ",HTML";
    else
      skills = skills + "HTML";
  }


  let user_records = new Array();
  user_records = JSON.parse(localStorage.getItem("users")) ? JSON.parse(localStorage.getItem("users")) : []
  if (user_records.some((v) => { return v.Email == email })) {
    alert("duplicate data");
  }
  else {
    user_records.push({
      "Name": name,
      "Email": email,
      "Website": website,
      "ImgLink": imglink,
      "Gender": gender,
      "Skills": skills,

    })
    localStorage.setItem("users", JSON.stringify(user_records));
    document.getElementById("studenttable").style.visibility = "visible";
  }

  showData();
}

function showData() {

  document.getElementById("student-data").innerHTML = "";
  let user_records = new Array();
  user_records = JSON.parse(localStorage.getItem("users")) ? JSON.parse(localStorage.getItem("users")) : []

  if (user_records.length) {

    for (let i = 0; i < user_records.length; i++) {
      let addDiv = document.createElement('div');
      var url = "";
      if (!/^(f|ht)tps?:\/\//i.test(user_records[i].Website)) {
        url = "http://" + user_records[i].Website;
      }
      addDiv.className = "row";
      addDiv.innerHTML = '<div class="student-detail row align-items-center"><div class="col-7 detail-column"><p><b>'+ user_records[i].Name + '</b></p><p>'+ user_records[i].Gender + '</p><p><a href="'+ url + '" target=blank>' + user_records[i].Website + '</a></p><p>'+ user_records[i].Email + '</p><p>'+ user_records[i].Skills + '</p></div><div class="col-4" style="border-left: 1px solid #98af97;display: flex;justify-content: center;align-items: center;"><img src="'+ user_records[i].ImgLink + '" height="125px" width="118px" alt="Student Picture" style="margin-left:30%"></div></div>';
      document.getElementById("student-data").appendChild(addDiv);

    }

  }
}

function validateForm() {
  var regName = /^[a-zA-Z]+ [a-zA-Z]+$/;
  var name = document.getElementById('Name').value;
  if (!regName.test(name)) {
    alert('Please enter your full name (first & last name).');
    document.getElementById('Name').focus();
    return false;
  }


  let website = document.getElementById("Website").value;
  var regWebsite = /^(?:(?:https?|ftp):\/\/)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/;
  if (!regWebsite.test(website)) {
    alert('Please enter Website URL Properly');
    document.getElementById('Website').focus();
    return false;
  }

  var checkboxs = document.getElementsByName("checkbox");
  var okay = false;
  for (var i = 0, l = checkboxs.length; i < l; i++) {
    if (checkboxs[i].checked) {
      okay = true;
      break;
    }
  }
  if (!okay) {
    alert("Please check a checkbox");
    return false;
  }


  let email = document.getElementById("Email");
  const regex = /^([\.\_a-zA-Z0-9]+)@([a-zA-Z]+)\.([a-zA-Z]){2,8}$/;
  const regexo = /^([\.\_a-zA-Z0-9]+)@([a-zA-Z]+)\.([a-zA-Z]){2,3}\.[a-zA-Z]{1,3}$/;
  if (regex.test(email.value) || regexo.test(email.value)) {
    return true;
  }
  else {
    alert("Invalid Email");
    document.getElementById("Email").focus();
    return false;
  }


}
