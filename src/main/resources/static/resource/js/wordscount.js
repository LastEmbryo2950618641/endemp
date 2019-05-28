$(function() {

  $(".select").click(function(){
    $(".select-context").fadeToggle() ;
  });

  $(".select-context p").click(function(){

      $(".select .title").html($(this).html());
      $(".select .title").attr({
          "value":$(this).attr("value")
      });
  }) ;

  $(".count-btn").click(function(){

    alert($(".per-container .inputArea textarea").val());
     var formData = new FormData();
     formData.append("dataType",$(".select .title").attr("value"));
     formData.append("dataText",$(".per-container .inputArea textarea").val());
      $.ajax({
        url:"",
        type:"POST",
        data:formData
      });

  });


});
