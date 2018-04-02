function setNowNode(_obj,_index) {
    $('#'+_obj+' td:lt('+_index+')').addClass('a-jg');
}
$(function() {
    setNowNode('a-jd',3);
});