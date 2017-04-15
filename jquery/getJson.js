/**
 * 把表单选中的input 序列化成json对象
 * @author cgl
 * @since 2016-09-28-12:02
 * @parameter selector 选择器，需要写全: id选择器写 '#id', class选择器 '.className'
 * @return  返回生成的json对象，包含需要序列化的参数键值对，格式为：{'a':1,'b':2}
 */
function getJson(selector){
 	var d = {};
    var t = $(selector).serializeArray();
    $.each(t, function() {
      d[this.name] = this.value;
    });
    return d;
}
