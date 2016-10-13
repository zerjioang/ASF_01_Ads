$(function(){
    item = $("#randomTitle");
    name = randomNameService.getTitulo();
    item.text(name);
});