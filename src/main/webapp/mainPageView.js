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
    var userInfo = [];
    userInfo.unshift(JSON.parse(xhr.response.toString()));
    showUserData(userInfo[0])
}

function showUserData(user) {
    var itemName = document.getElementById('name');
    itemName.innerHTML = 'Имя: ' + user.name;
    var itemAddress = document.getElementById('address');
    itemAddress.innerHTML = 'Адрес: ' + user.country + ', ' + user.index + ', ' + user.city + ', ' + user.street + ', ' + user.house;
    var itemPhone = document.getElementById('phone');
    itemPhone.innerHTML = 'Телефон: ' + user.phone;
    var itemWorkPlace = document.getElementById('workPlace');
    itemWorkPlace.innerHTML = 'Место работы: ' + user.company_name;
    var itemRole = document.getElementById('role');
    itemRole.innerHTML = 'Должность: ' + user.role;
    var editButton = document.getElementById('editButton');
    editButton.innerHTML = '<button onclick="editUserInfo()">Жопа (пока не работает)</button>';
    var deleteButton = document.getElementById('deleteButton');
    deleteButton.innerHTML = '<button onclick="deleteUser(' + user.id +')">Ну давай, удали уже, чего ты ждёшь</button>';
}

function editUserInfo() {

}

function addUser(values) {
    // values.toJSON();
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/user/update_user/', false);
    // xhr.add(values);
    xhr.send();
    if(xhr.status === 200){
        alert('Пользователь добавлен')
    } else
        alert('Ошибка добавления пользователя');
    location.reload()
}

function deleteUser(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user/delete_user/' + id, false);
    xhr.send();
    if(xhr.status === 200){
        alert('Пользователь удалён')
    } else
        alert('Извини, я тут не причём');
    location.reload()
}


