function getUsersList() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/user_list', false);
    xhr.send();
    var data = xhr.response;
    var usersArr = [];
    usersArr.unshift(data);
    var i;
    var list = document.getElementById('select');
    var item = document.createElement('option');
    for(i=0;i<=usersArr.length;i++){
            item.innerHTML = usersArr[i];
            list.appendChild(item.cloneNode(true));

    }
}

function getUserInfo(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/user_info/' + id, false);
    xhr.send();
    var data = xhr.response;
    var usersInfo = [];
    usersInfo.unshift(data);
}
