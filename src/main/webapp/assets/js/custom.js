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

var editor = new MediumEditor('.editable');

$(function () {
    $('.editable').mediumInsert({
    editor: null, // (MediumEditor) Instance of MediumEditor
    enabled: true, // (boolean) If the plugin is enabled
    addons: { // (object) Addons configuration
        embeds: { // (object) Embeds addon configuration
            label: '<span class="fa fa-youtube-play"></span>', // (string) A label for an embeds addon
            placeholder: 'Paste a YouTube, Vimeo, Facebook, Twitter or Instagram link and press Enter', // (string) Placeholder displayed when entering URL to embed
            captionPlaceholder: 'Type caption (optional)', // (string) Caption placeholder
            oembedProxy: 'http://medium.iframe.ly/api/oembed?iframe=1', // (string/null) URL to oEmbed proxy endpoint, such as Iframely, Embedly or your own. You are welcome to use "http://medium.iframe.ly/api/oembed?iframe=1" for your dev and testing needs, courtesy of Iframely. *Null* will make the plugin use pre-defined set of embed rules without making server calls.
            actions: { // (object) Actions for an optional second toolbar
                remove: { // (object) Remove action configuration
                    label: '<span class="fa fa-times"></span>', // (string) Label for an action
                    clicked: function ($el) { // (function) Callback function called when an action is selected
                        var $event = $.Event('keydown');

                        $event.which = 8;
                        $(document).trigger($event);   
                    }
                }
            }
        }
    }
});
});