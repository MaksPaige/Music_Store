var albumTableLength = 3;

function insertTrack() {
    alert('a');
    var tbody = document.getElementById('album-table').getElementsByTagName('tbody')[0];
    alert('b');
    var row = document.createElement('tr');
    tbody.appendChild(row);
    var td1 = document.createElement('td');
    var td2 = document.createElement('td');
    alert('c');
    row.appendChild(td1);
    row.appendChild(td2);
    td1.innerHTML = '<span>' + albumTableLength + '</span>';
    td2.innerHTML = '<span>Название трека #' + albumTableLength + '</span>';
    albumTableLength++;
}