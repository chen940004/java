<template>
    <div ref="chart" style="width: 600px; height: 400px;"></div>
  </template>
  
  <script>
  import * as echarts from 'echarts';
  import axios from 'axios';
  
  export default {
    data() {
      return {
        chartData: [],
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        try {
          const response = await axios.get('http://localhost:8081/house/district');
          const data = response.data;
          this.chartData = data;
          this.renderChart();
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
      renderChart() {
        const chart = echarts.init(this.$refs.chart);
  
        // 转换数据格式为南丁格尔玫瑰图所需格式
        const seriesData = this.chartData.map(item => ({
          name: item.district,
          value: item.count,
        }));
  
        const option = {
          title: {
            text: '各区房屋数量占比',
            left: 'center',
          },
          tooltip: {},
          series: [{
            name: '数量',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: seriesData,
            roseType: 'radius',
            label: {
              formatter: '{b}: {c} ({d}%)',
            },
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)',
              },
            },
          }],
        };
  
        chart.setOption(option);
      },
    },
  };
  </script>
  