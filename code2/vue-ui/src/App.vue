<template>
  <div
    id="app"
    class="container"
  >
    <aside class="sidebar">
      <div class="sidebar-buttons">
        <button
          @click="selectedComponent = 'DecorationChart'"
          class="sidebar-button"
        >在租房屋装修情况</button>
        <button
          @click="selectedComponent = 'ElevatorChart'"
          class="sidebar-button"
        >在租房屋电梯情况统计</button>
        <button
          @click="selectedComponent = 'TotalChart'"
          class="sidebar-button"
        >在租房屋价格统计</button>
        <button
          @click="selectedComponent = 'DistrictChart'"
          class="sidebar-button"
        >各区在租房屋数量统计</button>

      </div>
    </aside>
    <main>
      <header style="display: flex; justify-content: space-between; align-items: center;">
        <h2>{{ pageTitle }}</h2>
      </header>

      <section class="content">
        <component :is="selectedComponent" />
      </section>
    </main>
  </div>
</template>

<script>
// 导入其他图表组件
import DecorationChart from "./components/DecorationChart.vue";
import DistrictChart from "./components/DistrictChart.vue";
import ElevatorChart from './components/ElevatorChart.vue';
import TotalChart from './components/TotalChart.vue';

export default {
  name: "App",
  components: {
    DecorationChart,
    DistrictChart,
    ElevatorChart,
    TotalChart
  },
  data() {
    return {
      selectedComponent: "DistrictChart", // 默认显示的组件
      pageTitle: "房屋出租数据可视化", // 默认页面标题
    };
  },
};
</script>

<style>

html,
body {
  overflow: hidden; /* 阻止页面出现滚动条，并且不允许内容溢出 */
}

#app {
  display: flex;
  height: 100vh;
}

.container {
  width: 100%;
}

.sidebar {
  width: 200px;
  background-color: #545c64; /* 背景颜色 */
  color: white; /* 文字颜色 */
  padding: 20px;
}

.sidebar-buttons {
  display: flex;
  flex-direction: column;
}

.sidebar-button {
  padding: 10px;
  margin-bottom: 10px;
  cursor: pointer;
  background-color: #545c64; /* 按钮背景颜色 */
  color: white; /* 按钮文字颜色 */
  border: none;
}

.sidebar-button:hover {
  background-color: #6b757d; /* 鼠标悬停时按钮背景颜色 */
}

main {
  flex-grow: 1;
}

header {
  /* background-color: blanchedalmond;  */
  padding: 10px 20px; /* 调整内边距 */
  text-align: left; /* 文字居左 */
  border-bottom: 1px solid #ccc;
  font-size: 14px; /* 字体大小 */
  font-weight: normal; /* 字体粗细 */
}

.content {
  padding: 20px;
}
</style>
