<script>
import CountryDropdown from "@/components/CountryDropdown.vue";
export default {
  components: {CountryDropdown},
  data() {
    return {
      rates: {
        'GBP-USD': 1.250,
        'GBP-EUR': 1.170,
        'GBP-UAH': 37.020,
        'USD-UAH': 29.530,
        'USD-EUR': 0.940,
        'EUR-UAH': 31.570,
      },
      icons: {
        'GBP': '£',
        'USD': '$',
        'EUR': '€',
        'UAH': '₴'
      },
      symbol1: '£',
      symbol2: '£',
      currRate: 1.0.toFixed(3)
    }
  },
  mounted() {
    this.getRate();
  },
  methods: {
    showBuySell(row) {
      let elems = document.getElementsByClassName(row)
      for (let elem of elems) {
        elem.setAttribute('style', 'visibility: visible');
      }
    },
    hideBuySell(row) {
      let elems = document.getElementsByClassName(row)
      for (let elem of elems) {
        elem.setAttribute('style', 'visibility: hidden');
      }
    },
    getRate() {
      let curr1 = document.getElementById('currex1').innerText;
      let curr2 = document.getElementById('currex2').innerText;
      console.log(curr1)
      console.log(curr2)
      if (curr1 === curr2)
        this.currRate =  1.0.toFixed(3);
      let key = curr1 + "-" + curr2;
      let rate = this.rates[key];
      if (rate) {
        this.currRate = rate.toFixed(3);
      }
      key = curr2 + "-" + curr1;
      rate = this.rates[key];
      if (rate) {
        this.currRate = (1 / rate).toFixed(3);
      }
      this.update1();
      this.symbol1 = this.icons[curr1];
      this.symbol2 = this.icons[curr2];
    },
    update1() {
      let curr1 = document.getElementById('currEx1').value;
      console.log(curr1)
      if (curr1 === '') {
        document.getElementById('currEx2').value = null;
        return;
      }
      let curr2 = document.getElementById('currEx2').value;
      document.getElementById('currEx2').value = (curr1 * this.currRate).toFixed(3);
    },
    update2() {
      let curr1 = document.getElementById('currEx1').value;
      let curr2 = document.getElementById('currEx2').value;
      document.getElementById('currEx1').value = (curr2 / this.currRate).toFixed(3);
    }
  }
}
</script>

<template>
  <section class="u-clearfix u-custom-color-3 u-section-1" id="sec-a6ea">
    <div class="u-clearfix u-sheet u-sheet-1">
      <img class="u-image u-image-default u-preserve-proportions u-image-1" src="/src/assets/exchangeIcon.JPEG" alt=""
           data-image-width="1284" data-image-height="1284">
      <h1 class="u-align-center u-text u-text-1">Currency Exchange <br>
        <br>
      </h1>
      <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
        <div class="u-layout">
          <div class="u-layout-row">
            <div class="u-container-style u-custom-color-4 u-layout-cell u-size-40 u-layout-cell-1">
              <div class="u-container-layout u-container-layout-1">
                <div class="u-table u-table-responsive u-table-1">
                  <table class="u-table-entity">
                    <colgroup>
                      <col width="33.3%">
                      <col width="33.3%">
                      <col width="33.400000000000006%">
                    </colgroup>
                    <tbody class="u-table-alt-palette-1-light-3 u-table-body">
                    <tr style="height: 65px;">
                      <td class="u-align-center u-table-cell u-table-cell-1">Currency</td>
                      <td class="u-align-center u-table-cell">Buy</td>
                      <td class="u-align-center u-table-cell">Sell</td>
                    </tr>
                    <tr style="height: 65px;" @mouseover="showBuySell('curr-1')" @mouseleave="hideBuySell('curr-1')">
                      <td class="u-table-cell">USD<br>US Dollar
                      </td>
                      <td class="u-table-cell">1.0000</td>
                      <td class="u-table-cell">1.0000</td>
                    </tr>
                    <tr style="height: 65px;" @mouseover="showBuySell('curr-2')" @mouseleave="hideBuySell('curr-2')">
                      <td class="u-table-cell">GBP<br>Pound sterling
                      </td>
                      <td class="u-table-cell">1.1500</td>
                      <td class="u-table-cell">1.1500</td>
                    </tr>
                    <tr style="height: 65px;" @mouseover="showBuySell('curr-3')" @mouseleave="hideBuySell('curr-3')">
                      <td class="u-table-cell">UAH<br>Ukrainian hryvnia
                      </td>
                      <td class="u-table-cell">0.0320</td>
                      <td class="u-table-cell">0.0320</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-1 curr-1"
                     @mouseover="showBuySell('curr-1')" @mouseleave="hideBuySell('curr-1')">Sell</a>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-2 curr-1"
                     @mouseover="showBuySell('curr-1')" @mouseleave="hideBuySell('curr-1')">Buy</a>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-3 curr-2"
                     @mouseover="showBuySell('curr-2')" @mouseleave="hideBuySell('curr-2')">Buy</a>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-4 curr-3"
                     @mouseover="showBuySell('curr-3')" @mouseleave="hideBuySell('curr-3')">Buy</a>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-5 curr-2"
                     @mouseover="showBuySell('curr-2')" @mouseleave="hideBuySell('curr-2')">Sell</a>
                  <a href="https://nicepage.com/html-website-builder"
                     class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-6 u-btn-6 curr-3"
                     @mouseover="showBuySell('curr-3')" @mouseleave="hideBuySell('curr-3')">Sell</a>
              </div>
            </div>
            <div class="u-container-style u-layout-cell u-size-20 u-layout-cell-2">
              <div class="u-container-layout u-valign-top u-container-layout-2">
                <div class="u-container-style u-custom-color-4 u-group u-group-1">
                  <div class="u-container-layout u-container-layout-3">
                    <div class="u-align-left u-form u-form-1">
                        <div class="u-form-group u-label-top">
                          <input type="text" id="currEx1" @input="update1"
                                 class="u-border-1 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-1"
                                 required="required" placeholder="200">
                        </div>
                    </div>
                    <CountryDropdown num="1" @event="getRate"></CountryDropdown>
                    <div class="u-container-style u-custom-color-1 u-group u-radius-37 u-shape-round u-group-3">
                      <div class="u-container-layout u-valign-middle">
                        <p class="u-align-center u-text u-text-2">
                          1{{ symbol1 }} = {{ currRate }}{{ symbol2 }}
                        </p>
                      </div>
                    </div>
                    <div class="u-form u-form-2">
                        <div class="u-form-group u-label-top">
                          <input type="text" id="currEx2" @input="update2"
                                 class="u-border-1 u-border-grey-75 u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle u-input-2"
                                 required="required" placeholder="200">
                        </div>
                    </div>
                    <CountryDropdown num="2" @event="getRate"></CountryDropdown>
                    <a href="https://nicepage.com/web-design"
                       class="u-border-none u-btn u-btn-round u-button-style u-custom-color-1 u-hover-palette-1-light-1 u-radius-26 u-btn-9">Change
                      Currency<span style="font-size: 1.25rem;"></span>
                    </a>
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

<style scoped>
.curr-1, .curr-2, .curr-3 {
  visibility: hidden;
}

.u-section-1 {
  background-image: none;
}

.u-section-1 .u-sheet-1 {
  min-height: 100vh;
}

.u-section-1 .u-image-1 {
  width: 55px;
  height: 55px;
  margin: 21px auto 0 21px;
}

.u-section-1 .u-text-1 {
  font-size: 2rem;
  margin: -47px 732px 0 54px;
}

.u-section-1 .u-layout-wrap-1 {
  margin-top: 21px;
  margin-bottom: 60px;
}

.u-section-1 .u-layout-cell-1 {
  min-height: 399px;
  background-image: none;
}

.u-section-1 .u-container-layout-1 {
  padding: 0;
}

.u-section-1 .u-table-1 {
  width: 734px;
  margin: 21px auto 0;
}

.u-block-fb8d-16 {
  font-weight: 700;
  background-image: none;
}

.u-section-1 .u-table-cell-1 {
  font-weight: 400;
}

.u-section-1 .u-btn-1 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: -200px auto 0;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-btn-2 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: -48px 86px 0 auto;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-btn-3 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: 20px 86px 0 auto;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-btn-4 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: 25px 86px 0 auto;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-btn-5 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: -121px auto 0;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-btn-6 {
  border-style: none;
  font-weight: 700;
  font-size: 1.25rem;
  background-image: none;
  margin: 25px auto 0;
  padding: 8px 31px 8px 30px;
}

.u-section-1 .u-layout-cell-2 {
  min-height: 399px;
}

.u-section-1 .u-container-layout-2 {
  padding: 0;
}

.u-section-1 .u-group-1 {
  min-height: 296px;
  width: 359px;
  height: auto;
  margin: 0 0 0 auto;
}

.u-section-1 .u-container-layout-3 {
  padding: 30px 0 19px;
}

.u-section-1 .u-form-1 {
  height: 50px;
  margin: 0 30px 0 138px;
}

.u-section-1 .u-input-1 {
  height: 40px;
}

.u-section-1 .u-btn-7 {
  padding: 0;
}

.u-section-1 .u-group-2 {
  width: 76px;
  min-height: 43px;
  height: auto;
  margin: -50px auto 0 61px;
}

.u-section-1 .u-group-3 {
  min-height: 39px;
  width: 143px;
  margin: 25px 7px 0 auto;
}

.u-section-1 .u-text-2 {
  font-size: 1.25rem;
  margin: 0 12px;
}

.u-section-1 .u-form-2 {
  height: 50px;
  margin: 12px 30px 0 138px;
}

.u-section-1 .u-input-2 {
  height: 40px;
}

.u-section-1 .u-btn-8 {
  padding: 0;
}

.u-section-1 .u-group-4 {
  width: 76px;
  min-height: 43px;
  height: auto;
  margin: -51px auto 0 61px;
}

.u-section-1 .u-btn-9 {
  border-style: none;
  font-size: 1.25rem;
  background-image: none;
  font-weight: normal;
  margin: 37px auto 0;
  padding: 8px 15px 8px 13px;
}

@media (max-width: 1199px) {
  .u-section-1 .u-text-1 {
    margin-right: 586px;
    margin-left: 0;
  }

  .u-section-1 .u-layout-wrap-1 {
    position: relative;
  }

  .u-section-1 .u-layout-cell-1 {
    min-height: 329px;
  }

  .u-section-1 .u-table-1 {
    width: 627px;
  }

  .u-section-1 .u-btn-2 {
    margin-right: 0;
  }

  .u-section-1 .u-btn-3 {
    margin-right: 0;
  }

  .u-section-1 .u-btn-4 {
    margin-right: 0;
  }

  .u-section-1 .u-layout-cell-2 {
    min-height: 329px;
  }

  .u-section-1 .u-group-1 {
    width: 313px;
    height: auto;
  }

  .u-section-1 .u-form-1 {
    margin-right: 7px;
    margin-left: 115px;
  }

  .u-section-1 .u-group-2 {
    height: auto;
  }

  .u-section-1 .u-form-2 {
    margin-right: 7px;
    margin-left: 115px;
  }

  .u-section-1 .u-group-4 {
    height: auto;
  }
}

@media (max-width: 991px) {
  .u-section-1 .u-text-1 {
    margin-right: 366px;
  }

  .u-section-1 .u-layout-cell-1 {
    min-height: 100px;
  }

  .u-section-1 .u-table-1 {
    width: 480px;
  }

  .u-section-1 .u-layout-cell-2 {
    min-height: 100px;
  }

  .u-section-1 .u-group-1 {
    width: 240px;
  }

  .u-section-1 .u-form-1 {
    margin-right: 0;
    margin-left: 49px;
  }

  .u-section-1 .u-group-3 {
    margin-right: 0;
  }

  .u-section-1 .u-form-2 {
    margin-right: 0;
    margin-left: 49px;
  }
}

@media (max-width: 767px) {
  .u-section-1 .u-text-1 {
    margin-right: 186px;
  }
}

@media (max-width: 575px) {
  .u-section-1 .u-text-1 {
    font-size: 1.875rem;
    margin-right: 0;
  }

  .u-section-1 .u-table-1 {
    width: 340px;
  }
}
</style>