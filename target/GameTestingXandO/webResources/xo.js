var currentPlayer = 'X';
var box = ['', '', '', '', '', '', '', '', ''];


function resetGame() {

    for (var i = 0; i < box.length; i++) {
        document.getElementById(i.toString()).innerHTML = '&nbsp';
        document.getElementById(i.toString()).setAttribute("onclick", "f(" + i.toString() + ")");
        box[i] = '';
    }

    document.getElementById("Win-div").innerHTML = '';
    document.getElementById("xPlayer").checked = true;
    currentPlayer = 'X';
}



function setPlayer() {

    var x = document.getElementById("xPlayer");
    var o = document.getElementById("oPlayer");
    if (x.checked) {
        currentPlayer = 'X'
    }
    if (o.checked) {
        currentPlayer = 'O'
    }

}




function f(id) {
    document.getElementById(id).innerHTML = currentPlayer;
    box[id] = currentPlayer;
    checkWinner();

}


function checkWinner() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        console.log(this.getAllResponseHeaders());
        if (this.readyState == 4 && this.status == 200) {
            var myObj = JSON.parse(this.responseText);
            if (myObj.win) {
                document.getElementById("Win-div").innerHTML = "----------" + currentPlayer + " wins!----------";
                for (var i = 0; i < box.length; i++) {
                    document.getElementById(i.toString()).removeAttribute("onclick");
                }
            }else {
                currentPlayer = ('X' == currentPlayer) ? 'O' : 'X';
                if(boadFull()){
                    document.getElementById("Win-div").innerHTML ="----------Sorry,nobody wins!----------";
                    for (var i = 0; i < box.length; i++) {
                        document.getElementById(i.toString()).removeAttribute("onclick");
                    }

                }
            }
        }
        ;
    }
    var matrixStateConverted = JSON.stringify(box);
    xhttp.open("POST", "/GameTestingXandO_war_exploded/ServletHuman", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var body = "matrix=" + matrixStateConverted;
    xhttp.send(body);
}

function boadFull() {

    for( var i=0; i < box.length; i++){
        if(box[i] == '')
            return false;
    }
    return true;
}





