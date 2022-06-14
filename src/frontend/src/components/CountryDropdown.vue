<script>
export default {
  props: ['num'],
  data() {
    return {
    }
  },
  mounted() {
    let x = '.dropdown' + this.num
    let x1 = '.dropdown-menu' + this.num
    $(x).click(function () {
      $(this).attr('tabindex', 1).focus();
      $(this).toggleClass('active');
      $(this).find(x1).slideDown(300);
      if (!$(this).hasClass('active')) {
        $(this).find(x1).slideUp(300);
      }
    });
    $(x).focusout(function () {
      $(this).removeClass('active');
      $(this).find(x1).slideUp(300);
    });
    let comp = this;
    // '.dropdown' + this.num + ' .dropdown-menu' + this.num + ' li'
    $('.dropdown' + this.num + ' .dropdown-menu' + this.num + ' li').click(function () {
      $(this).parents(x).find('span').text($(this).text());
      comp.$emit('event');
      console.log('event')
    });

  }
}
</script>

<template>
  <div class="u-container-style u-grey-10 u-group u-group-2" style="height: 40px; background-color: #334756;">
    <div class="u-container-layout" style="height: 40px; background-color: #334756;">

      <div :class="'dropdown' + num" style="width: 76px; height: 40px">
        <div class="select" style="height: 40px; background-color: #334756; outline: none">
          <span :id="'currex' + num" style="color: white; margin: 40px auto auto;">GBP</span>
        </div>
        <ul :class="'dropdown-menu' + num">
          <li :id="'gbp' + num">GBP</li>
          <li :id="'usd' + num">USD</li>
          <li :id="'eur' + num">EUR</li>
          <li :id="'uah' + num">UAH</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<style scoped>
span.msg,
span.choose {
  color: #555;
  padding: 5px 0 10px;
  display: inherit
}
.container {
  width: 500px;
  margin: 50px auto 0;
  text-align: center
}

/*Styling Selectbox*/
.dropdown1, .dropdown2 {
  width: 300px;
  display: inline-block;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 0 2px rgb(204, 204, 204);
  transition: all .5s ease;
  position: relative;
  font-size: 14px;
  color: #474747;
  height: 100%;
  text-align: left
}
.dropdown1 .select, .dropdown2 .select {
  cursor: pointer;
  display: block;
  padding: 10px
}
.dropdown1 .select > i, .dropdown2 .select > i {
  font-size: 13px;
  color: #888;
  cursor: pointer;
  transition: all .3s ease-in-out;
  float: right;
  line-height: 20px
}
.dropdown1:hover, .dropdown2:hover {
  box-shadow: 0 0 4px rgb(204, 204, 204)
}
.dropdown1:active, .dropdown2:active {
  background-color: #f8f8f8
}
.dropdown1.active:hover,
.dropdown1.active,
.dropdown2.active:hover,
.dropdown2.active{
  box-shadow: 0 0 4px rgb(204, 204, 204);
  border-radius: 2px 2px 0 0;
  background-color: #f8f8f8
}
.dropdown1.active .select > i, .dropdown2.active .select > i {
  transform: rotate(-90deg)
}
.dropdown1 .dropdown-menu1, .dropdown2 .dropdown-menu2 {
  position: absolute;
  background-color: #fff;
  width: 100%;
  left: 0;
  margin-top: 1px;
  box-shadow: 0 1px 2px rgb(204, 204, 204);
  border-radius: 0 1px 2px 2px;
  overflow: hidden;
  display: none;
  max-height: 144px;
  overflow-y: auto;
  z-index: 9
}
.dropdown1 .dropdown-menu1 li,.dropdown2 .dropdown-menu2 li {
  padding: 10px;
  transition: all .2s ease-in-out;
  cursor: pointer
}
.dropdown1 .dropdown-menu1, .dropdown2 .dropdown-menu2 {
  padding: 0;
  list-style: none
}
.dropdown1 .dropdown-menu1 li:hover, .dropdown2 .dropdown-menu2 li:hover {
  background-color: #f2f2f2
}
.dropdown1 .dropdown-menu1 li:active, .dropdown2 .dropdown-menu2 li:active {
  background-color: #e2e2e2
}
</style>