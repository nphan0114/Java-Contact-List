$(document).ready(function(){ 

//top nav bar sticky to top of page ---------------------------
function sticky_relocate() {
      var window_top = jQuery(window).scrollTop() + 0;
      var div_top = jQuery('#sticky-anchor').offset().top;
      if (window_top > div_top)
        jQuery('#header').addClass('sticky')
      else
        jQuery('#header').removeClass('sticky');
      }
     
   jQuery(function() {
      jQuery(window).scroll(sticky_relocate);
      sticky_relocate();
      });

// load nav menu
$(function() {
 $('.container').load('nav.html');
});


// form add another input ---------------------------
$(function() {
  $('.hidden').hide();
  $('.addInput').on('click', function() {
    $(this).next().toggle('fast');
      $expand = $(this).find(">:first-child");
         if ($expand.text() == "^") {
            $expand.text("+add another");
          }
          else {
            $expand.text("^");
          }
  });
}); 

// New hire page expand ---------------------------
$(function() {
  $('.expand').on('click', function() {
    $(this).next().toggle('fast');
      $expand = $(this).find(">:first-child");
         if ($expand.text() == "^") {
            $expand.text("+");
          }
          else {
            $expand.text("^");
          }
  });
}); 

// clear and hideall inputs fields ---------------------------
$(function() {
  $('#resetForm').on('click', function() {
    document.getElementById('ss-form').reset();
    $('.hidden').hide();
    $expand = $('.addInput').find(">:first-child");
      if ($expand.text() == "^") {
            $expand.text("+add another");
          }
          else {
            $expand.text("+add another");
          }
  });
});


});