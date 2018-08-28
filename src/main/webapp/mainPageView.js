function getUsers() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/user_list', false);
    xhr.send();
    var usersArr = [];
    usersArr.unshift(JSON.parse(xhr.response.toString()));
    return usersArr[0];
}

function setUsersList() {
    var users = getUsers();
    var list = document.getElementById('select');
    var item = document.createElement('option');
    for (var i = 0; i < users.length; i++) {
        item.innerHTML = users[i].name;
        item.setAttribute('value', users[i].id);
        list.appendChild(item.cloneNode(true));
    }
}

function getUserInfo(id) {
    var users = getUsers();
    for (var i = 0; i <= users; i++) {
        if (id === users[i].id) {
            id = users[i].id;
        }
    }
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/user_info/' + id, false);
    xhr.send();
    var data = xhr.response;
    var userInfo = [];
    userInfo.unshift(data);
    showUserData(userInfo[0])
}

function showUserData(user) {

    var element = document.getElementById('div');
    element.setIdAttribute('visibility', true);
    var userId = user.id;
    var name = user.name;
    var address = user.country + ' ' + user.city + ' ' + user.street + ' ' + user.house;
    var phone = user.phone;
    var workPlace = user.company_name;
    var role = user.role;
}

function editUserInfo(id) {
}

function deleteUser(id) {
}


