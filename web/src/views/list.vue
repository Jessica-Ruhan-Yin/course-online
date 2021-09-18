<template>
  <main role="main">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div v-for="o in courses" class="col-md-4">
            <the-course v-bind:course="o"/>
          </div>
          <h3 v-show="courses.length === 0">课程还未上架</h3>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import TheCourse from "@/components/the-course";

export default {
  name: "list",
  components: {TheCourse},
  data: function () {
    return {
      courses: [],
    }
  },

  mounted() {
    let _this = this;
    _this.listCourse();
  },

  methods: {
    /**
     * 查询课程列表
     */
    listCourse() {
      let _this = this;
    },

  }
}
</script>

<style>
.title {
  margin-bottom: 2rem;
  color: #fafafa;
  letter-spacing: 0;
  text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135;
  font-size: 2rem;
}
</style>
