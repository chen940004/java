<template>
    <div>
      <h2>共计房屋数量 {{ totalCount }} </h2>
      <div ref="chart" style="width: 600px; height: 400px;"></div>
    </div>
  </template>
  
  <script>
  import * as echarts from 'echarts';
  import axios from 'axios';
  
  export default {
    data() {
      return {
        chartData: [],
        totalCount: 0,
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        try {
          const response = await axios.get('http://localhost:8081/house/total');
          this.chartData = response.data.filter(item => item.summary !== 'count');
          this.totalCount = response.data.find(item => item.summary === 'count').toal_price;
          this.renderChart();
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
      renderChart() {
        const chart = echarts.init(this.$refs.chart);
        const indicatorData = this.chartData.map(item => ({ name: item.summary, max: item.toal_price }));
  
        const option = {
          title: {
            text: '房屋价格统计',
            left: 'center',
          },
          tooltip: {},
          radar: {
            indicator: indicatorData,
          },
          series: [{
            type: 'radar',
            data: [{
              value: this.chartData.map(item => item.toal_price),
            }],
          }],
        };
  
        chart.setOption(option);
      },
    },
  };
  </script>
  