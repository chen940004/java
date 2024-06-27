<template>
    <div>
      <div id="chart" style="width: 600px; height: 400px;"></div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import * as echarts from 'echarts';
  
  export default {
    data() {
      return {
        chartData: [] // 用于存储ECharts饼图的数据
      };
    },
    mounted() {
      // 在组件加载完成后渲染ECharts图表
      this.fetchCityDemandList();
    },
    methods: {
      fetchCityDemandList() {
        // 使用axios或其他HTTP库从后端API获取城市需求列表数据
        axios.get('http://localhost:8081/house/decoration')
          .then(response => {
            // 将获取到的数据保存到chartData中
            this.chartData = response.data;
            // 渲染ECharts图表
            this.renderChart();
          })
          .catch(error => {
            console.error('Error fetching list:', error);
          });
      },
      renderChart() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart'));
        // 指定图表的配置项和数据
        var option = {
          title: {//标题居中
            left: 'center',
            text: '房屋装修情况(饼图)',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            left: 10,
            data: this.chartData.map(item => item.decoration)
          },
          series: [{
            name: '装修情况',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: this.chartData.map(item => ({
              name: item.decoration,
              value: item.count
            })),
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
      }
    }
  };
  </script>
  