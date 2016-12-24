<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/8
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="../../static/hplus/css/bootstrap.min.css-v=3.3.5.css" rel="stylesheet">
  <link href="../../static/hplus/css/font-awesome.min.css-v=4.4.0.css" rel="stylesheet">
  <link href="../../static/hplus/css/animate.min.css" rel="stylesheet">
  <link href="../../static/hplus/css/style.min.css-v=4.0.0.css" rel="stylesheet">
  <link href="../../static/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
  <link href="../../static/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <div class="form-inline">
            <div class="form-group">
              <select class="form-control" name="comptype" id="comptype">
                <option value="1">单位名称</option>
              </select>
              <input type="text" name="keywords" id="keywords" class="form-control">
            </div>
            <button name="search" id="search" class="btn btn-success"><i
                    class="fa fa-search"></i>
              搜索
            </button>
          </div>
          <br/>
        </div>
        <div class="ibox-content">
          <table id="oTable" class="table table-striped table-bordered table-hover dataTables-example">
            <thead>
            <tr>
              <th width="25">
                <input type="checkbox">
              </th>
              <th>单位名称</th>
              <%--<th>省</th>
              <th>市</th>
              <th>县</th>--%>
              <th>联系电话</th>
              <th>紧急联系人</th>
              <th>紧急联系电话</th>
              <th>状态</th>
              <th>审核时间</th>
              <th>添加时间</th>
            </tr>
            </thead>
          </table>

        </div>
      </div>
    </div>
  </div>
</div>
<script src="../../static/js/jquery-1.8.3.min.js"></script>
<script src="../../static/layer/layer.js"></script>
<script src="../../static/datatables/js/jquery.dataTables.js"></script>
<script src="../../static/datatables/js/dataTables.bootstrap.js"></script>
<script src="../../static/js/public.js"></script>
<script type="text/javascript">
  var oTable;
  $(document).ready(function () {
    oTable = $('#oTable').dataTable({
      'bServerSide': true,
      "bAutoWidth": false,
      "processing": true,
      "serverSide": true,
      "sScrollX": true,
      "ordering": false,
      "searching": false,

      "dom": 't<"bottom"iflpr<"clear">>',
      "ajax": {
        "url": "/comp/getCompList",
        "data": function (d) {
          d.comptype = $("#comptype  option:selected").val();  //请求参数
          d.keywords = $('#keywords').val();  //请求参数
        }
      },
      "columnDefs": [{
        "render": function (data, type, row) {
          return "<td><input type='radio' value='" + row[0] + "' name='checkList' onClick='layerParentVal(" + row[0] + ",\"" + row[1] + "\")'></td>"
        },
        "targets": 0,
      }],
      "language": {
        "url": "../static/datatables/i18n/Chinese.json"
      }
    });

    $('#search').click(function () {
      oTable.fnDraw();
    });
  });

  function layerParentVal(id,val){
    parent.$('#companyCode').val(id);
    parent.$('#companyName').val(val);
    layer_close()
  }

</script>
</body>
</html>
