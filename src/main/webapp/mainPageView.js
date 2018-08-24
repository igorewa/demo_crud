function getUsersList() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/user_list', false);
    xhr.send();
    var data = xhr.response;
    var usersArr = [];
    usersArr.unshift(data);
    var i;
    for(i=0;i<=usersArr.length;i++){

    }
}

function setUsersInList() {
}
