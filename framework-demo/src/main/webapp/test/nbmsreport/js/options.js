/**
 * Created by junhuiji on 2016/1/25.
 */
allOption = {
    title : {
        text: '消息发送总量统计',
        x:'left'
    },
    tooltip : {
        trigger: 'item' ,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        left: 'center',
        data: ['短信','邮件','商麦']
    },
    series : [
        {
            name: '消息发送总量',
            type: 'pie',
            //radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:1324074, name:'短信'},
                {value:2306671, name:'邮件'},
                {value:2061, name:'商麦'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

/**
 * 按月统计 各个消息通道的发送总量
 * @type {{tooltip: {trigger: string, axisPointer: {type: string}}, legend: {data: string[]}, grid: {left: string, right: string, bottom: string, containLabel: boolean}, xAxis: *[], yAxis: *[], series: *[]}}
 */
sendMsgGroupByMonth = {
    title : {
        text: '各类型消息发送总量',
        x:'left'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data:['短信','邮件']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            //dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true}
            //saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    calculable : true,
    series : [
        {
            name:'短信',
            type:'bar',
            data:[3823,25361,115242,109384,111668,114402,127120,121181,139908,131502,159810,164673],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'邮件',
            type:'bar',
            data:[13,1090,8234,25360,51387,72367,99725,212972,360052,251713,565295,658463],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }
        //,
        //{
        //    name:'商麦',
        //    type:'bar',
        //    data:[0,0,0,28,31,23,5,170,154,267,647,736] ,
        //    markPoint : {
        //        data : [
        //            {type : 'max', name: '最大值'},
        //            {type : 'min', name: '最小值'}
        //        ]
        //    },
        //    markLine : {
        //        data : [
        //            {type : 'average', name: '平均值'}
        //        ]
        //    }
        //
        //}
    ]
};


/**
 * 按月统计 各产品线 短信发送总量
 * @type {{tooltip: {trigger: string, axisPointer: {type: string}}, legend: {data: string[]}, grid: {left: string, right: string, bottom: string, containLabel: boolean}, xAxis: *[], yAxis: *[], series: *[]}}
 */
sendSmsTotalGroupByMonth = {
    title : {
        text: '各产品线短信发送总量',
//					subtext: '纯属虚构',
        x:'left'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data:['政务','必联网','悦采SAAS','私有云','武汉营销','悦采2.0','大买家','石药集团','基础服务']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            //dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true}
            //saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    calculable : true,
    series : [
        {
            name:'政务',
            type:'bar',
            data:[15,387,73396,17204,82624,101354,45526,25476,97040,22907,120062,69586],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        } ,
        {
            name:'必联网',
            type:'bar',
            data:[0,0,0,0,1,222,899,1983,1852,2592,3114,3886],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }  ,
        {
            name:'悦采SAAS',
            type:'bar',
            data:[0,0,0,0,0,0,0,0,392,306,1232,3692],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }  ,
        {
            name:'私有云',
            type:'bar',
            data:[843,3604,17511,33597,33856,39368,39823,52640,75464,91086,134960,115765],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }  ,
        {
            name:'武汉营销',
            type:'bar',
            data:[5092,1540,3708,4280,12030,6250,17067,27124,30057,19030,36507,11478],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        } ,
        {
            name:'悦采2.0',
            type:'bar',
            data:[317,3056,18488,18124,18756,18742,23988,10500,22926,3476,5211,3560],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }   ,
        {
            name:'大买家',
            type:'bar',
            data:[0,40392,58110,55850,89946,45905,49082,70594,30531,58604,55204,31641],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }      ,
        {
            name:'石药集团',
            type:'bar',
            data:[118,755,4751,3140,7672,3897,4220,3742,3891,2722,3331,4147],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }        ,
        {
            name:'基础服务',
            type:'bar',
            data:[0,0,0,819,1585,1412,1634,1551,1404,1264,1825,2574],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }
    ]
};


/**
 * 按 产品线 统计 各个消息的发送总量
 * @type {{tooltip: {trigger: string, axisPointer: {type: string}}, legend: {data: string[]}, grid: {left: string, right: string, bottom: string, containLabel: boolean}, xAxis: *[], yAxis: *[], series: *[]}}
 */
sendMsgGroupByProduct = {
    title : {
        text: '各类型消息发送总量',
//					subtext: '纯属虚构',
        x:'left'
    },
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data:['短信','邮件']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['政务','必联网','悦采SAAS','私有云','武汉营销','悦采2.0','大买家','石药集团','基础服务']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'短信',
            type:'bar',
            data:[249992,7542,4039,431918,61826,85104,38550,428489,13423]
        },
        {
            name:'邮件',
            type:'bar',
            stack: '广告',
            data:[300736,1625139,125912,95045,0,7481,28831,0,123525]
        }
    ]
};

/**
 * 按 产品线统计 短信的发送量
 * @type {{title: {text: string, x: string}, tooltip: {trigger: string, formatter: string}, legend: {orient: string, left: string, data: string[]}, series: *[]}}
 */
sendSmsTotalGroupByProduct = {
    title : {
        text: '短信发送总量统计',
        x:'left'
    },
    tooltip : {
        trigger: 'item' ,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {

        left: 'center',
        data: ['政务','必联网','悦采SAAS','私有云','武汉营销','悦采2.0','大买家','石药集团','基础服务']
    },
    series : [
        {
            name: '短信发送总量',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:638517, name:'私有云'},
                {value:5915, name:'悦采SAAS'},
                {value:174163, name:'武汉营销中心'} ,
                {value:147144, name:'悦采2.0'},
                {value:585859, name:'大买家'},
                {value:42386, name:'石药集团'}   ,
                {value:14549, name:'必联网'},
                {value:655577, name:'政务'},
                {value:14068, name:'基础服务'},
                {value:3191, name:'商麦'}
            ]
        }
    ]
};
/**
 * 号码归属地统计
 * @type {{title: {text: string, subtext: string, left: string}, tooltip: {trigger: string}, legend: {orient: string, left: string, data: string[]}, visualMap: {min: number, max: number, left: string, top: string, text: string[], calculable: boolean}, toolbox: {show: boolean, orient: string, left: string, top: string, feature: {mark: {show: boolean}, dataView: {show: boolean, readOnly: boolean}, restore: {show: boolean}, saveAsImage: {show: boolean}}}, series: *[]}}
 */
yuecaiOption = {
    title : {
        text: '悦采客户群手机号归属地',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },
    dataRange: {
        min: 0,
        max: 12666,
        x: 'left',
        y: 'bottom',
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    roamController: {
        show: true,
        x: 'right',
        mapTypeControl: {
            'china': true
        }
    },
    series : [
        {
            name: '悦采',
            type: 'map',
            mapType: 'china',
            roam: false,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                //{name:"山东",value:12666},{name:"河北",value:12003},{name:"内蒙古",value:10371},{name:"四川",value:6854},{name:"江苏",value:6233},{name:"河南",value:4943},{name:"浙江",value:3356},{name:"广东",value:3273},{name:"北京",value:3187},{name:"宁夏",value:2513},{name:"天津",value:2393},{name:"上海",value:2183},{name:"陕西",value:2052},{name:"湖北",value:1955},{name:"山西",value:1896},{name:"辽宁",value:1816},{name:"安徽",value:1584},{name:"云南",value:1246},{name:"黑龙江",value:1159},{name:"重庆",value:791},{name:"甘肃",value:681},{name:"吉林",value:579},{name:"湖南",value:561},{name:"广西",value:443},{name:"福建",value:378},{name:"青海",value:359},{name:"江西",value:290},{name:"新疆",value:125},{name:"贵州",value:124},{name:"海南",value:26},{name:"西藏",value:7}
                {
                    name:"山东", value:12666
                },{name:"河北",value:12003},{name:"内蒙古",value:10371},{name:"四川",value:6854},{name:"江苏",value:6233},{name:"河南",value:4943},{name:"浙江",value:3356},{name:"广东",value:3273},{name:"北京",value:3187},{name:"宁夏",value:2513},{name:"天津",value:2393},{name:"上海",value:2183},{name:"陕西",value:2052},{name:"湖北",value:1955},{name:"山西",value:1896},{name:"辽宁",value:1816},{name:"安徽",value:1584},{name:"云南",value:1246},{name:"黑龙江",value:1159},{name:"重庆",value:791},{name:"甘肃",value:681},{name:"吉林",value:579},{name:"湖南",value:561},{name:"广西",value:443},{name:"福建",value:378},{name:"青海",value:359},{name:"江西",value:290},{name:"新疆",value:125},{name:"贵州",value:124},{name:"海南",value:26},{name:"西藏",value:7}
            ]
        }
        //{
        //    name: '必联网',
        //    type: 'map',
        //    mapType: 'china',
        //    roam: false,
        //    itemStyle:{
        //        normal:{label:{show:true}},
        //        emphasis:{label:{show:true}}
        //    },
        //    data:[
        //        {name:"北京",value:313},{name:"上海",value:239},{name:"广东",value:95},{name:"江苏",value:80},{name:"浙江",value:43},{name:"山东",value:42},{name:"四川",value:41},{name:"天津",value:30},{name:"湖北",value:23},{name:"陕西",value:22},{name:"河北",value:21},{name:"湖南",value:19},{name:"吉林",value:14},{name:"河南",value:13},{name:"重庆",value:10},{name:"辽宁",value:10},{name:"云南",value:9},{name:"黑龙江",value:9},{name:"安徽",value:8},{name:"新疆",value:8},{name:"贵州",value:6},{name:"福建",value:5},{name:"山西",value:2},{name:"广西",value:2},{name:"宁夏",value:2},{name:"江西",value:1}
        //    ]
        //},
        //{
        //    name: '商麦',
        //    type: 'map',
        //    mapType: 'china',
        //    roam: false,
        //    itemStyle:{
        //        normal:{label:{show:true}},
        //        emphasis:{label:{show:true}}
        //    },
        //    data:[
        //        {name:"北京",value:438},{name:"广东",value:53},{name:"湖南",value:53},{name:"河北",value:43},{name:"四川",value:31},{name:"江苏",value:26},{name:"河南",value:22},{name:"湖北",value:20},{name:"浙江",value:20},{name:"上海",value:19},{name:"山东",value:18},{name:"贵州",value:16},{name:"新疆",value:15},{name:"陕西",value:13},{name:"天津",value:13},{name:"辽宁",value:11},{name:"福建",value:10},{name:"山西",value:7},{name:"江西",value:7},{name:"云南",value:7},{name:"重庆",value:7},{name:"内蒙古",value:5},{name:"安徽",value:5},{name:"宁夏",value:4},{name:"黑龙江",value:4},{name:"吉林",value:4},{name:"甘肃",value:3},{name:"广西",value:2},{name:"黑龙江",value:3}
        //    ]
        //}, {
        //    name: '政务',
        //    type: 'map',
        //    mapType: 'china',
        //    roam: false,
        //    itemStyle:{
        //        normal:{label:{show:true}},
        //        emphasis:{label:{show:true}}
        //    },
        //    data:[
        //        {name:"北京",value:15634},{name:"上海",value:7373},{name:"广东",value:5113},{name:"浙江",value:4393},{name:"江苏",value:3896},{name:"山东",value:3594},{name:"陕西",value:3407},{name:"天津",value:2854},{name:"湖北",value:2845},{name:"四川",value:2537},{name:"云南",value:2009},{name:"河北",value:1983},{name:"重庆",value:1949},{name:"黑龙江",value:1803},{name:"山西",value:1688},{name:"辽宁",value:1654},{name:"湖南",value:1612},{name:"安徽",value:1564},{name:"河南",value:1547},{name:"福建",value:1545},{name:"吉林",value:1377},{name:"江西",value:1288},{name:"新疆",value:919},{name:"甘肃",value:810},{name:"广西",value:700},{name:"贵州",value:634},{name:"内蒙古",value:620},{name:"海南",value:416},{name:"宁夏",value:211},{name:"青海",value:95},{name:"西藏",value:1}
        //    ]
        //}

    ]
};

blwOption = {
    title : {
        text: '必联网客户群手机号归属地',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },
    dataRange: {
        min: 0,
        max: 313,
        x: 'left',
        y: 'bottom',
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    roamController: {
        show: true,
        x: 'right',
        mapTypeControl: {
            'china': true
        }
    },
    series : [

        {
            name: '必联网',
            type: 'map',
            mapType: 'china',
            roam: false,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name:"北京",value:313},{name:"上海",value:239},{name:"广东",value:95},{name:"江苏",value:80},{name:"浙江",value:43},{name:"山东",value:42},{name:"四川",value:41},{name:"天津",value:30},{name:"湖北",value:23},{name:"陕西",value:22},{name:"河北",value:21},{name:"湖南",value:19},{name:"吉林",value:14},{name:"河南",value:13},{name:"重庆",value:10},{name:"辽宁",value:10},{name:"云南",value:9},{name:"黑龙江",value:9},{name:"安徽",value:8},{name:"新疆",value:8},{name:"贵州",value:6},{name:"福建",value:5},{name:"山西",value:2},{name:"广西",value:2},{name:"宁夏",value:2},{name:"江西",value:1}
            ]
        }

    ]
};

smOption = {
    title : {
        text: '商麦客户群手机号归属地',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },
    dataRange: {
        min: 0,
        max: 438,
        x: 'left',
        y: 'bottom',
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    roamController: {
        show: true,
        x: 'right',
        mapTypeControl: {
            'china': true
        }
    },
    series : [
        {
            name: '商麦',
            type: 'map',
            mapType: 'china',
            roam: false,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name:"北京",value:438},{name:"广东",value:53},{name:"湖南",value:53},{name:"河北",value:43},{name:"四川",value:31},{name:"江苏",value:26},{name:"河南",value:22},{name:"湖北",value:20},{name:"浙江",value:20},{name:"上海",value:19},{name:"山东",value:18},{name:"贵州",value:16},{name:"新疆",value:15},{name:"陕西",value:13},{name:"天津",value:13},{name:"辽宁",value:11},{name:"福建",value:10},{name:"山西",value:7},{name:"江西",value:7},{name:"云南",value:7},{name:"重庆",value:7},{name:"内蒙古",value:5},{name:"安徽",value:5},{name:"宁夏",value:4},{name:"黑龙江",value:4},{name:"吉林",value:4},{name:"甘肃",value:3},{name:"广西",value:2},{name:"黑龙江",value:3}
            ]
        }

    ]
};

zwOption = {
    title : {
        text: '政务客户群手机号归属地',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },
    dataRange: {
        min: 0,
        max: 15634,
        x: 'left',
        y: 'bottom',
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    roamController: {
        show: true,
        x: 'right',
        mapTypeControl: {
            'china': true
        }
    },
    series : [
         {
            name: '政务',
            type: 'map',
            mapType: 'china',
            roam: false,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name:"北京",value:15634},{name:"上海",value:7373},{name:"广东",value:5113},{name:"浙江",value:4393},{name:"江苏",value:3896},{name:"山东",value:3594},{name:"陕西",value:3407},{name:"天津",value:2854},{name:"湖北",value:2845},{name:"四川",value:2537},{name:"云南",value:2009},{name:"河北",value:1983},{name:"重庆",value:1949},{name:"黑龙江",value:1803},{name:"山西",value:1688},{name:"辽宁",value:1654},{name:"湖南",value:1612},{name:"安徽",value:1564},{name:"河南",value:1547},{name:"福建",value:1545},{name:"吉林",value:1377},{name:"江西",value:1288},{name:"新疆",value:919},{name:"甘肃",value:810},{name:"广西",value:700},{name:"贵州",value:634},{name:"内蒙古",value:620},{name:"海南",value:416},{name:"宁夏",value:211},{name:"青海",value:95},{name:"西藏",value:1}
            ]
        }

    ]
};
