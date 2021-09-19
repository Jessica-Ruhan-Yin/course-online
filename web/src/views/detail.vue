<template>
  <main role="main">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row course-head">
          <div class="col-sm-6" id="cover-video-div">
            <img class="img-fluid" v-bind:src="course.image">
          </div>
          <div class="col-sm-6">
            <h2>{{ course.name }}</h2>
            <p class="course-head-item">
              <span><i class="fa fa-clock-o"></i> {{ (course.time) | formatSecond }}</span>
              <span>{{ COURSE_LEVEL | optionKV(course.level) }}</span>
              <span><i class="fa fa-user"></i> {{ course.enroll }}</span>
            </p>
            <p class="course-head-desc">{{ course.summary }}</p>
            <p class="course-head-price">
              <span class="price-now text-danger"><i class="fa fa-yen"></i>&nbsp;{{ course.price }}&nbsp;&nbsp;&nbsp;&nbsp;</span>
              <span class="course-head-button-links">
              <a class="btn btn-lg btn-primary btn-shadow smaller" href="javascript:;">立即报名</a>
            </span>
            </p>
          </div>
        </div>
      </div>
    </div>
  </main>

</template>

<script>
export default {
  name: "detail",
  data: function () {
    return {
      id: "",
      course: {},
      chapters: [],
      sections: [],
      teacher: {},
      COURSE_LEVEL: COURSE_LEVEL
    }
  },

  mounted() {
    let _this = this;
    _this.id = _this.$route.query.id;
    _this.findCourse();
  },

  methods: {

    findCourse() {
      let _this = this;
      _this.$ajax.get('http://127.0.0.1:9000/business/web/course/find/' + _this.id).then((response) => {
        let resp = response.data;
        _this.course = resp.content;
        _this.teacher = resp.course.teacher || {};
        _this.chapters = resp.course.chapters || {};
        _this.sections = resp.course.sections || {};
      })
    }
  }
}
</script>

<style scoped>
.course-head {
}

.course-head h1 {
  font-size: 2rem;
  margin-bottom: 1.5rem;
}

.course-head-item span {
  margin-right: 1rem;
}

.course-head-desc {
  font-size: 1rem;
  color: #555
}

.course-head a {
}

.course-head-price {
  font-size: 2rem;
}

@media (max-width: 700px) {
  .course-head h1 {
    font-size: 1.5rem;
  }
}
</style>