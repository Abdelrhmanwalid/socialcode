// grab an element
var elem = document.querySelector("header");
// construct an instance of Headroom, passing the element
var headroom = new Headroom(elem);
headroom.init();



hljs.initHighlightingOnLoad();


// init controller
// var controller = new ScrollMagic.Controller();

// // create a scene
// new ScrollMagic.Scene({
//         duration: 100,    // the scne should last for a scroll distance of 100px
//         offset: 50        // start this scene after scrolling for 50px
//     })
//     .setPin("#topper") // pins the element for the the scene's duration
//     .addTo(controller); // assign the scene to the controller



$(function() {
	$('select').selectize({
	    sortField: 'text'
	});
});


$(document).ready(function(){
  $('input').iCheck({
    checkboxClass: 'icheckbox_square-orange',
    radioClass: 'iradio_square-orange',
    //increaseArea: '20%' // optional
  });
});