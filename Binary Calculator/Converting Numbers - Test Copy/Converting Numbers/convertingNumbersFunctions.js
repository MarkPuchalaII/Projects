//This function computes all textboxes based upon which one you pressed Enter on.
// The function works as follows: compute(input box's ID, Input type's base number)

//Declare a variable to track which input was most recently used
var label;

/******************************************************
 *******  compute() updates all the fields      *******
 *******  based on which is being used          *******
 *******  It does so through updateAllFields()  *******
 ******************************************************/
function compute(label,calculation,convert){
  //var number = document.getElementById(label);
  var inputValue = String(label.value); //Take the value of the input box as a string for testing
  if (label.id == 'binary'){
    convert = 2;
  } else if (label.id == 'octal'){
    convert = 8;
  } else if (label.id == 'decimal'){
    convert = 10;
  } else if (label.id == 'hexadecimal'){
    convert = 16;
  }
  if (calculation==true){
    updateAllFields(inputValue, convert);
  } else{
    update(label.id,convert,inputValue,convert);
  }
}

/****************************************************************
 *******  updateAllFields() calculates all boxes at once. *******
 *******  It is used when ANY value is tested           *********
 ****************************************************************/
function updateAllFields(inputValue,convert){
  var input = ['binary', 'octal', 'decimal', 'hexadecimal'];
  var value = [2, 8, 10, 16];
  for (i = 0; i < input.length; i++){
    var object = update(input[i],value[i],inputValue,convert);
    if (object == 'error'){
      alert('ERROR: Number limit reached\n'+
            'Max inputs allowed are: \n'+
            'Binary: 1111-1111-1111-1111\n'+
            'Octal: 177,777\n'+
            'Decimal: 65,535\n'+
            'Hexadecimal: ffff');
      return refresh();
      break;
    }
  }
}

/**************************************************************
 *******  update() calculates a single boxe's value.    *******
 *******      It is used by updateAllFields()           *******
 **************************************************************/
function update(object,value,inputValue,convert){
  var object = document.getElementById(object);
  object.value = parseInt(inputValue,convert).toString(value);
  if (object.selectionEnd > 16){
    return 'error';
  }
  if (object.value == 'NaN'){
    return refresh();
  }
}


/*******************************************************
 *******     refresh() resets all textboxes.     *******
 *******  It is used when any box reaches "NaN"  *******
 *******************************************************/

function refresh(label){
  var input = ['binary', 'octal', 'decimal', 'hexadecimal'];
  for (i = 0; i < input.length; i++){
    if (input[i] != label){//Erase any field that wasn't just input
                            //This means all fields if a button called the function
      var refresher = document.getElementById(input[i]);
      refresher.value = '';
    }
  }
}
