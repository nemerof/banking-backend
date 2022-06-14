<script>
import AccountNumber from '@/components/AccountNumber.vue'
import Profile from '@/views/Profile.vue'
import ServicesList from "@/components/ServicesList.vue";

export default {
  components: {ServicesList},
  data() {
    return {
      iti: null,
      errorText: ''
    }
  },
  mounted() {
    let recaptchaScript = document.createElement('script')
    recaptchaScript.setAttribute('src', 'intl_tel_input/build/js/intlTelInput.js')
    document.head.appendChild(recaptchaScript)

    let input = document.querySelector("#phone");
    window.intlTelInput(input, {
      separateDialCode: true,
      autoPlaceholder: 'aggressive',
      preferredCountries: ['ua', 'pl'],
      utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js"
    })
    let iti = window.intlTelInputGlobals.getInstance(input);
    this.iti = iti
  },
  methods: {
    phoneRefill() {
      let number = this.iti.getNumber()
      let isValid = this.iti.isValidNumber()
      if (!isValid) {
        this.errorText = 'Invalid Number Entered'
      } else {
        this.errorText = ''
      }
    },
    phoneCheck() {
      this.errorText = ''
    }
  }
}
</script>

<template>
  <section class="u-clearfix u-custom-color-3 u-section-1" id="sec-68d0">
    <div class="u-align-left u-clearfix u-sheet u-sheet-1">
      <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
        <div class="u-layout">
          <div class="u-layout-row">
            <ServicesList></ServicesList>
            <div class="u-size-46">
              <div class="u-layout-col">
                <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-2">
                  <div class="u-container-layout u-container-layout-4">
                    <div class="u-carousel u-expanded-width u-gallery u-gallery-slider u-layout-carousel u-lightbox u-no-transition u-show-text-on-hover u-gallery-1" id="carousel-f035" data-interval="5000" data-u-ride="carousel">
                      <ol class="u-absolute-hcenter u-carousel-indicators u-carousel-indicators-1">
                        <li data-u-target="#carousel-f035" data-u-slide-to="0" class="u-active u-grey-70 u-shape-circle" style="width: 10px; height: 10px;"></li>
                        <li data-u-target="#carousel-f035" data-u-slide-to="1" class="u-grey-70 u-shape-circle" style="width: 10px; height: 10px;"></li>
                      </ol>
                      <div class="u-carousel-inner u-gallery-inner" role="listbox">
                        <div class="u-active u-carousel-item u-effect-fade u-gallery-item u-carousel-item-1">
                          <div class="u-back-slide">
                            <a href="https://eurovision.tv">
                              <img class="u-back-image u-expanded" src="/src/assets/news1.JPEG">
                            </a>
                          </div>
                        </div>
                        <div class="u-carousel-item u-effect-fade u-gallery-item u-carousel-item-2">
                          <div class="u-back-slide">
                            <img class="u-back-image u-expanded" src="/src/assets/news2.JPEG">
                          </div>
                        </div>
                      </div>
                      <a class="u-absolute-vcenter u-carousel-control u-carousel-control-prev u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-carousel-control-1" href="#carousel-f035" role="button" data-u-slide="prev">
                          <span aria-hidden="true">
                            <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
                          </span>
                        <span class="sr-only">
                            <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
                          </span>
                      </a>
                      <a class="u-absolute-vcenter u-carousel-control u-carousel-control-next u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-carousel-control-2" href="#carousel-f035" role="button" data-u-slide="next">
                          <span aria-hidden="true">
                            <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
                          </span>
                        <span class="sr-only">
                            <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
                          </span>
                      </a>
                    </div>
                  </div>
                </div>
                <div class="u-container-style u-layout-cell u-size-30 u-layout-cell-3">
                  <div class="u-container-layout u-container-layout-5">
                    <div class="u-align-left u-container-style u-custom-color-4 u-group u-group-3">
                      <div class="u-container-layout u-container-layout-6">
                        <p class="u-align-center u-text u-text-custom-color-2 u-text-3">Transfer to Card</p>
                        <div class="u-form u-form-1">
                          <div class="u-clearfix u-form-horizontal u-form-spacing-7 u-inner-form" style="padding: 5px;">
                            <div class="u-form-group">
                              <input type="text" id="cardInput" name="card" class="u-border-1 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2" required="required" placeholder="0000 0000 0000 0000">
                            </div>
                          </div>
                        </div>
                        <button @click="cardTransfer()" class="u-align-left u-custom-color-2 u-file-icon u-icon u-icon-circle u-opacity u-opacity-65 u-icon-6" style="cursor: pointer">
                          <img src="/src/assets/8.png" alt="">
                        </button>
                        <div class="u-align-left u-container-style u-group u-group-4">
                          <div class="u-container-layout">
                            <p class="u-align-center u-text u-text-custom-color-6 u-text-4">Bank Card</p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="u-align-left u-container-style u-custom-color-4 u-group u-group-5">
                      <div class="u-container-layout u-container-layout-8">
                        <p class="u-align-center u-text u-text-custom-color-2 u-text-5">Phone Number</p>
                        <div class="u-form u-form-2">
                          <div class="u-clearfix u-form-horizontal u-form-spacing-7 u-inner-form" style="padding: 5px;">
                            <div class="u-form-group">
                              <input @keydown="phoneCheck()" type="tel" id="phone" name="phone" class="u-border-1 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2" required="required">
                            </div>
                          </div>
                        </div>
                        <button @click="phoneRefill()" class="u-align-left u-custom-color-2 u-file-icon u-icon u-icon-circle u-opacity u-opacity-65 u-icon-6" style="cursor: pointer">
                          <img src="/src/assets/8.png" alt="">
                        </button>
                        <div class="u-align-left u-container-style u-group u-group-4">
                          <div class="u-container-layout">
                            <p class="u-align-center u-text u-text-custom-color-606 u-text-4" style="width: 200px">{{ errorText }}</p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="u-align-left u-container-style u-custom-color-4 u-group u-group-6">
                      <div class="u-container-layout u-container-layout-9">
                        <p class="u-align-center u-text u-text-custom-color-2 u-text-6">Payment</p>
                        <div class="u-form u-form-3">
                          <div class="u-clearfix u-form-horizontal u-form-spacing-7 u-inner-form" style="padding: 5px;">
                            <div class="u-form-group">
                              <input type="text" id="accountInput" name="account" class="u-border-1 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2" required="required" placeholder="PL 0000 0000 0000 0000">
                            </div>
                          </div>
                        </div>
                        <button @click="numberTransfer()" class="u-align-left u-custom-color-2 u-file-icon u-icon u-icon-circle u-opacity u-opacity-65 u-icon-6" style="cursor: pointer">
                          <img src="/src/assets/8.png" alt="">
                        </button>
                        <div class="u-container-style u-group u-group-7">
                          <div class="u-container-layout">
                            <p class="u-align-center u-text u-text-custom-color-6 u-text-7">Account number</p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="u-align-center u-container-style u-custom-color-4 u-group u-group-8">
                      <div class="u-container-layout u-container-layout-11">
                        <p class="u-text u-text-custom-color-2 u-text-8">Digital Card Issue</p>
                        <button @click="cardIssue()" class="u-custom-color-2 u-file-icon u-icon u-icon-circle u-opacity u-opacity-65 u-icon-8">
                          <img src="/src/assets/8.png" alt="">
                        </button>
                        <img class="u-image u-image-default u-image-1" src="/src/assets/card1.JPEG" alt="" data-image-width="1280" data-image-height="853">
                        <p class="u-text u-text-custom-color-2 u-text-9">Comission-free Issue and Delivery</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<style>
#phone {
  width: 240px;
}

.u-text-custom-color-606 {
  color: red;
}

.iti__highlight, .iti__country-list {
  background-color: #082032;
}

.iti {
  width: 240px;
  margin-left: -50px;
}

button {
  cursor: pointer;
}

.u-section-1 .u-sheet-1 {
  min-height: 1200px;
}

.u-section-1 .u-layout-wrap-1 {
  margin-top: 40px;
  margin-bottom: 60px;
}

.u-section-1 .u-layout-cell-1 {
  min-height: 1006px;
}

.u-section-1 .u-container-layout-1 {
  padding: 14px 0;
}

.u-section-1 .u-group-1 {
  min-height: 47px;
  width: 234px;
  margin: 0 auto;
}

.u-section-1 .u-container-layout-2 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-1 {
  font-size: 1.25rem;
  transition-duration: 0.5s;
  margin: 4px 7px 0 30px;
}

.u-section-1 .u-icon-1 {
  width: 16px;
  height: 16px;
  margin: -21px 0 0 auto;
  padding: 0;
}

.u-section-1 .u-icon-2 {
  width: 32px;
  height: 32px;
  margin: -27px auto 0 14px;
  padding: 0;
}

.u-section-1 .u-group-2 {
  min-height: 47px;
  width: 234px;
  margin: 16px auto 0;
}

.u-section-1 .u-container-layout-3 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-2 {
  font-size: 1.25rem;
  margin: 4px 30px 0;
}

.u-section-1 .u-icon-3 {
  width: 16px;
  height: 16px;
  margin: -21px 0 0 auto;
  padding: 0;
}

.u-section-1 .u-icon-4 {
  width: 32px;
  height: 32px;
  margin: -27px auto 0 14px;
  padding: 0;
}

.u-section-1 .u-layout-cell-2 {
  min-height: 331px;
}

.u-section-1 .u-container-layout-4 {
  padding: 0 30px;
}

.u-section-1 .u-gallery-1 {
  height: 344px;
  margin-top: 0;
  margin-bottom: 0;
}

.u-section-1 .u-carousel-indicators-1 {
  position: absolute;
  width: auto;
  height: auto;
  top: auto;
  bottom: 11px;
}

.u-section-1 .u-carousel-item-1 {
  margin-right: 0;
}

.u-section-1 .u-over-slide-1 {
  background-image: linear-gradient(0deg, rgba(0,0,0,0.2), rgba(0,0,0,0.2));
  padding: 30px;
}

.u-section-1 .u-carousel-item-2 {
  margin-right: 0;
}

.u-section-1 .u-over-slide-2 {
  background-image: linear-gradient(0deg, rgba(0,0,0,0.2), rgba(0,0,0,0.2));
  padding: 30px;
}

.u-section-1 .u-carousel-control-1 {
  position: absolute;
  left: 10px;
  width: 40px;
  height: 40px;
  right: auto;
}

.u-section-1 .u-carousel-control-2 {
  position: absolute;
  width: 40px;
  height: 40px;
  left: auto;
  right: 10px;
}

.u-section-1 .u-layout-cell-3 {
  min-height: 662px;
}

.u-section-1 .u-container-layout-5 {
  padding: 0 29px;
}

.u-section-1 .u-group-3 {
  width: 400px;
  min-height: 170px;
  margin: 32px auto 0 0;
}

.u-section-1 .u-container-layout-6 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-3 {
  font-size: 1.25rem;
  margin: 14px 214px 0 23px;
}

.u-section-1 .u-form-1 {
  height: 50px;
  margin: 18px 59px 0 16px;
}

.u-section-1 .u-input-1 {
  height: 40px;
}

.u-section-1 .u-btn-1 {
  padding: 0;
}

.u-section-1 .u-icon-5 {
  width: 38px;
  height: 38px;
  color: rgb(0, 0, 0) !important;
  transition-duration: 0.5s;
  margin: -45px 11px 0 auto;
  padding: 4px;
}

.u-section-1 .u-group-4 {
  width: 76px;
  min-height: 37px;
  margin: 2px auto 0 40px;
}

.u-section-1 .u-text-4 {
  margin: 0 0 0 -17px;
}

.u-section-1 .u-group-5 {
  width: 400px;
  min-height: 170px;
  margin: -170px 0 0 auto;
}

.u-section-1 .u-container-layout-8 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-5 {
  font-size: 1.25rem;
  margin: 15px 225px 0 12px;
}

.u-section-1 .u-form-2 {
  height: 50px;
  margin: 17px 59px 0 83px;
}

.u-section-1 .u-input-2 {
  height: 40px;
}

.u-section-1 .u-btn-2 {
  padding: 0;
}

.u-section-1 .u-icon-6 {
  width: 38px;
  background-image: none;
  height: 38px;
  color: rgb(0, 0, 0) !important;
  margin: -45px 11px 0 auto;
  padding: 4px;
}

.u-section-1 .u-group-6 {
  width: 400px;
  min-height: 170px;
  margin: 23px auto 0 0;
}

.u-section-1 .u-container-layout-9 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-6 {
  font-size: 1.25rem;
  margin: 15px 266px 0 15px;
}

.u-section-1 .u-form-3 {
  height: 50px;
  margin: 17px 59px 0 23px;
}

.u-section-1 .u-input-3 {
  height: 40px;
}

.u-section-1 .u-btn-3 {
  padding: 0;
}

.u-section-1 .u-icon-7 {
  width: 38px;
  background-image: none;
  height: 38px;
  color: rgb(0, 0, 0) !important;
  margin: -45px 11px 0 auto;
  padding: 4px;
}

.u-section-1 .u-group-7 {
  width: 76px;
  min-height: 37px;
  margin: 3px auto 0 49px;
}

.u-section-1 .u-text-7 {
  margin: 0 -40px 0 -17px;
}

.u-section-1 .u-group-8 {
  width: 400px;
  min-height: 169px;
  margin: -169px 0 0 auto;
}

.u-section-1 .u-container-layout-11 {
  padding-left: 0;
  padding-right: 0;
}

.u-section-1 .u-text-8 {
  font-size: 1.25rem;
  margin: 14px 219px 0 15px;
}

.u-section-1 .u-icon-8 {
  width: 38px;
  background-image: none;
  height: 38px;
  color: rgb(0, 0, 0) !important;
  margin: -35px 12px 0 auto;
  padding: 4px;
}

.u-section-1 .u-image-1 {
  width: 185px;
  height: 90px;
  margin: 6px auto 0 15px;
}

.u-section-1 .u-image-2 {
  width: 38px;
  height: 38px;
  margin: -26px auto 0 9px;
}

.u-section-1 .u-text-9 {
  margin: -70px 53px 0 209px;
}

@media (max-width: 1199px) {
  .u-section-1 .u-sheet-1 {
    min-height: 1024px;
  }

  .u-section-1 .u-layout-cell-1 {
    min-height: 830px;
  }

  .u-section-1 .u-group-1 {
    width: 219px;
    transition-duration: 0.5s;
    transform: translateX(0px) translateY(0px) scale(1) rotate(0deg);
  }

  .u-section-1 .u-text-1 {
    margin-left: 23px;
    margin-right: 23px;
    transform: translateX(10px) translateY(0px) scale(1);
  }

  .u-section-1 .u-group-2 {
    width: 219px;
  }

  .u-section-1 .u-text-2 {
    margin-left: 23px;
    margin-right: 23px;
    transition-duration: 0.5s;
    transform: translateX(10px) translateY(0px) scale(1);
  }

  .u-section-1 .u-layout-cell-2 {
    min-height: 273px;
  }

  .u-section-1 .u-layout-cell-3 {
    min-height: 546px;
  }

  .u-section-1 .u-icon-5 {
    transform: translateX(10px) translateY(0px) scale(1);
  }

  .u-section-1 .u-group-5 {
    margin-top: 20px;
  }

  .u-section-1 .u-group-8 {
    margin-top: 20px;
  }
}

@media (max-width: 991px) {
  .u-section-1 .u-sheet-1 {
    min-height: 394px;
  }

  .u-section-1 .u-layout-cell-1 {
    min-height: 100px;
  }

  .u-section-1 .u-group-1 {
    width: 168px;
  }

  .u-section-1 .u-text-1 {
    margin-left: 10px;
    margin-right: 0;
  }

  .u-section-1 .u-group-2 {
    width: 168px;
  }

  .u-section-1 .u-text-2 {
    margin-left: 0;
    margin-right: 0;
  }

  .u-section-1 .u-layout-cell-2 {
    min-height: 235px;
  }

  .u-section-1 .u-layout-cell-3 {
    min-height: 382px;
  }

  .u-section-1 .u-group-5 {
    margin-top: -170px;
  }

  .u-section-1 .u-group-8 {
    margin-top: -169px;
  }
}

@media (max-width: 767px) {
  .u-section-1 .u-sheet-1 {
    min-height: 494px;
  }

  .u-section-1 .u-layout-cell-2 {
    min-height: 246px;
  }

  .u-section-1 .u-container-layout-4 {
    padding-left: 10px;
    padding-right: 10px;
  }

  .u-section-1 .u-layout-cell-3 {
    min-height: 400px;
  }

  .u-section-1 .u-container-layout-5 {
    padding-left: 10px;
    padding-right: 10px;
  }
}

@media (max-width: 575px) {
  .u-section-1 .u-layout-cell-2 {
    min-height: 155px;
  }

  .u-section-1 .u-layout-cell-3 {
    min-height: 252px;
  }

  .u-section-1 .u-group-3 {
    width: 320px;
  }

  .u-section-1 .u-text-3 {
    margin-right: 157px;
    margin-left: 0;
  }

  .u-section-1 .u-form-1 {
    margin-right: 0;
    margin-left: 0;
  }

  .u-section-1 .u-group-5 {
    width: 320px;
  }

  .u-section-1 .u-text-5 {
    margin-right: 157px;
    margin-left: 0;
  }

  .u-section-1 .u-form-2 {
    margin-right: 19px;
    margin-left: 43px;
  }

  .u-section-1 .u-group-6 {
    width: 320px;
  }

  .u-section-1 .u-text-6 {
    margin-right: 201px;
    margin-left: 0;
  }

  .u-section-1 .u-form-3 {
    margin-right: 2px;
    margin-left: 0;
  }

  .u-section-1 .u-group-8 {
    width: 320px;
  }

  .u-section-1 .u-text-8 {
    margin-right: 154px;
    margin-left: 0;
  }

  .u-section-1 .u-text-9 {
    margin-right: 13px;
    margin-left: 169px;
  }
}

.u-section-1 .u-text-1,
.u-section-1 .u-text-1:before,
.u-section-1 .u-text-1 > .u-container-layout:before {
  transition-property: fill, color, background-color, stroke-width, border-style, border-width, border-top-width, border-left-width, border-right-width, border-bottom-width, custom-border, borders, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position;
}

.u-section-1 .u-icon-5,
.u-section-1 .u-icon-5:before,
.u-section-1 .u-icon-5 > .u-container-layout:before {
  transition-property: fill, color, background-color, stroke-width, border-style, border-width, border-top-width, border-left-width, border-right-width, border-bottom-width, custom-border, borders, box-shadow, text-shadow, opacity, border-radius, stroke, border-color, font-size, font-style, font-weight, text-decoration, letter-spacing, transform, background-image, background-size, background-position;
}
</style>
