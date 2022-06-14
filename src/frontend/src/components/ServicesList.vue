<script>
export default {
  data() {
    return {
      serviceNames: [],
      serviceIcons: [],
      serviceLinks: []
    }
  },
  beforeMount() {
    let l1 = ['Transfers', 'Payments', 'Mobile Network']
    this.serviceNames.push.apply(this.serviceNames, l1)
    let l2 = ['icon1', 'icon2', 'icon3']
    this.serviceIcons.push.apply(this.serviceIcons, l2)
    let l3 = ['/transfers', '/payments', '/mobile']
    this.serviceLinks.push.apply(this.serviceLinks, l3)
  }
}
</script>

<template>
  <div class="u-size-14">
    <div class="u-layout-col">
      <div class="u-container-style u-custom-color-4 u-layout-cell u-size-60 u-layout-cell-1">
        <div class="u-container-layout u-container-layout-1">
          <div v-for="(name, index) in serviceNames">
            <RouterLink class="u-align-left u-container-style u-group u-group-1" :to="serviceLinks[index]">
              <div class="u-container-layout u-container-layout-2">
                <p class="u-align-center u-hover-feature u-text u-text-1">
                  <span class="u-text-custom-color-2">{{ name }}</span>
                </p><span class="u-file-icon u-icon u-text-custom-color-2 u-icon-1"><img src="/src/assets/5.png" alt=""></span>
                <img class="u-image u-image-default u-image-2" :src="'/src/assets/' + serviceIcons[index] + '.JPEG'" alt="" data-image-width="609" data-image-height="611">
              </div>
            </RouterLink>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>