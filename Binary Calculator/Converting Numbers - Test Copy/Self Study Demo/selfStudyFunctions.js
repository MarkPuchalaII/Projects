var instructions = ['Start with our number',
                    'Write in groups',
                    'Write 2^n under each',
                    'Figure their powers',
                    'Multply top by bottom',
                    'Sum up each group',
                    'And we have our number!'];

var showWork =      ['101001011010',
                     '101|001|011|010',
                     '<span style="font-size: 0.4em">2<sup>2</sup> 2<sup>1</sup> 2<sup>0</sup></span>-'+
                     '<span style="font-size: 0.4em">2<sup>2</sup> 2<sup>1</sup> 2<sup>0</sup></span> -'+
                     '<span style="font-size: 0.4em">2<sup>2</sup> 2<sup>1</sup> 2<sup>0</sup></span>-'+
                     '<span style="font-size: 0.4em">2<sup>2</sup> 2<sup>1</sup> 2<sup>0</sup></span>',
                     '421|421|421|421',
                     '4+1| -1- |2+1|-2-',
                     '--5----1----3----2--',
                     '--------5,123-------'];

var table = new table();
var count = 1;
function table(){
  this.create = function(div,caption){
    document.getElementById(div).innerHTML +=
    '<table id="Table2">'+
      '<caption id="caption">'+
        caption+
      '</caption>'+
    '</table>';
  }

  this.changeItem = function(div,newItem){
    document.getElementById(div).innerHTML = newItem;
  }

  this.newRow = function(div,newInfo,mouseover){
    document.getElementById(div).innerHTML +=
    '<tr id="row">'+
      '<td title="'+mouseover+'">'+
        newInfo+
      '</td>'+
    '</tr>';
  }

  this.newCell = function(div,newInfo){
    document.getElementById(div).innerHTML +=
    '<td>'+
      newInfo+
    '</td>';
  }
}


function demonstrate(){

  switch (count){
    case 1:
      table.create("binaryHints",instructions[0]);
      table.newRow("Table2",showWork[0],instructions[0]);
      break;
    case 2:
      table.changeItem("caption", instructions[1]);
      table.newRow("Table2",showWork[1],instructions[1]);
      break;
    case 3:
      table.changeItem("caption", instructions[2]);
      table.newRow("Table2",showWork[2],instructions[2]);
      break;
    case 4:
      table.changeItem("caption", instructions[3]);
      table.newRow("Table2",showWork[3],instructions[3]);
      break;
    case 5:
      table.changeItem("caption", instructions[4]);
      table.newRow("Table2",showWork[4],instructions[4]);
      break;
    case 6:
      table.changeItem("caption", instructions[5]);
      table.newRow("Table2",showWork[5],instructions[5]);
      break;
    case 7:
      table.changeItem("caption", instructions[6]);
      table.newRow("Table2",showWork[6],instructions[6]);
      break;
    default:
      document.getElementById('test').disabled = true;
      break;
  }
  count++;
}

function refresh(label){
  var input = ['binary', 'octal', 'decimal', 'hexadecimal'];
  for (i = 0; i < input.length; i++){
    if (input[i] != label){//Erase any field that wasn't just input
                            //This means all fields if a button called the function
      var refresher = document.getElementById(input[i]);
      refresher.value = '';
    }
  }
  input = ['binaryHints', 'octalHints', 'decimalHints', 'hexadecimalHints'];
  for (i = 0; i < input.length; i++){
    if (input[i] != label){//Erase any field that wasn't just input
                            //This means all fields if a button called the function
      var refresher = document.getElementById(input[i]);
      refresher.innerHTML = '';
    }
  }
  count = 1;
}
