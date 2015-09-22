$(function(){
  $('h1').editable('mouseover');
  
  // edit button
  var option = {trigger : $('.age .btn_edit'), action : 'click'};
  $('.age .editable').editable(option, function(e){
    if(!e.value.match(/^\d+$/)){
      $('.age .editable').html(e.old_value);
      alert(e.value + ' is not valid age');
    }
    else{
      alert('save : '+e.value);
    }
  });

  // textarea
  $('.textarea .editable').editable({type: 'textarea', action: 'click'}, function(e){
    console.log(e.value);
  });

});
