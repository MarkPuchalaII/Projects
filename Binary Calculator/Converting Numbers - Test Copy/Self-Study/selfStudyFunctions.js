var instructions = ['Start with our number',
                    'Write in groups',
                    'Write 2^n under each',
                    'Figure their powers',
                    'Multply top by bottom',
                    'Sum up each group'];

var showWork =      ['101 001 011 010',
                     '321 321 321 321',
                     '421 421 421 421',
                     '401 001 021 020',
                     ' 5   1   3   2 ',
                     '     5,123     '];

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

  this.newRow = function(div,newInfo){
    document.getElementById(div).innerHTML +=
    '<tr id="row">'+
      '<td>'+
        newInfo+
      '</td>'+
    '</tr>';
  }

  this.newCell = function(div){
    document.getElementById(div).innerHTML +=
    '<td>'+
      'test'+
    '</td>';
  }
}


function demonstrate(){
  switch (count){
    case 1:
      table.create("binaryHints",instructions[0]);
      table.newRow("Table2",showWork[0]);
      break;
    case 2:
      table.changeItem("caption", instructions[1]);
      table.newRow("Table2",showWork[1]);
      break;
    case 3:
      table.changeItem("caption", instructions[2]);
      table.newRow("Table2",showWork[2]);
      break;
    case 4:
      table.changeItem("caption", instructions[3]);
      table.newRow("Table2",showWork[3]);
      break;
    case 5:
      table.changeItem("caption", instructions[4]);
      table.newRow("Table2",showWork[4]);
      break;
    case 6:
      table.changeItem("caption", instructions[5]);
      table.newRow("Table2",showWork[5]);
      break;
  }
  if (count > 6){
    document.getElementById('test').disabled = true;
  };
  count++;
}
