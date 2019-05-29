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


     var formData = new FormData();
     formData.append("dataType",$(".select .title").attr("value"));
     formData.append("dataText",$(".per-container .inputArea textarea").val());



      $.ajax({
          url:contextPath+"/WordsCounts/count",
          type:"POST",
          data:formData,
          contentType: false,
          processData: false,
          success:function (data) {
              console.log(data);
              var an=date.resultText;
              $("#result").val(an);

          },
          error:function () {
              $("#result").val("数据错误");
          }
      });


  });


});
