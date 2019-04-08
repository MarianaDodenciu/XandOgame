

window.onload = () => {
  getLastThreeWinnngMatches();
}



//var board = ['', '', '', '', '', '', '', '', ''];
//var board2 =['', '', '', '', '', '', '', '', ''];
//var board3 =['', '', '', '', '', '', '', '', ''];



function getLastThreeWinnngMatches() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState == 4 && this.status == 200){
            var match = this.responseText;
            var str = match.split("\]");

           var str1 = str[0].substring(2,str[0].length).split(",");
           for(var i=0; i< str1.length; i++){
                str1[i] = str1[i].replace(/^"(.*)"$/, '$1');}

           var str2 = str[1].substring(3,str[1].length).split(",");
           for(var i=0; i< str2.length; i++){
                    str2[i] = str2[i].replace(/^"(.*)"$/, '$1');}

           var str3= str[2].substring(3,str[2].length).split(",");
           for(var i=0; i< str3.length; i++){
                   str3[i] = str3[i].replace(/^"(.*)"$/, '$1');}

           for(var i=0; i < 9;i++) {
               if (str1[i] == "") {
                    document.getElementById(i.toString()).innerHTML = '\xa0';
               } else {
                   document.getElementById(i.toString()).innerHTML = str1[i];
               }
           }
           for(var i=0; i < 9; i++) {
               if (str2[i] == "") {
                   document.getElementById((i + 9).toString()).innerHTML = '\xa0';
               } else {
                   document.getElementById((i + 9).toString()).innerHTML = str2[i];
               }
           }
           for(var i=0; i < 9; i++) {
               if (str3[i] == "") {
                   document.getElementById((i + 18).toString()).innerHTML = '\xa0';
               } else {
                   document.getElementById((i + 18).toString()).innerHTML = str3[i];
               }
           }


            console.log(str1);
            console.log(str2);
            console.log(str3);

        }
    };

    xhttp.open("Get","/GameTestingXandO_war_exploded/ServletHistory",true);
    xhttp.send();
}






