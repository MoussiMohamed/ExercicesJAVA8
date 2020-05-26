<template>
  <div align="center">
    <h1>Liste des Lots</h1>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Description</th>
      </tr>
      <tr v-for="lot in lots" 
          :key="lot.id">
        <td>
          <span>{{lot.id}}</span>
        </td>
        <td>
          <span>{{lot.description}}</span>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
/* eslint-disable */

import axios from "axios";
import LotService from "../services/LotService";

export default {
  name: "Lots",
  data() {
    return {
      msg: "Liste des Lots",
      lots: [],
      sale_id: ""
    };
  },
  mounted() {
    this.load();
  },
  methods: {
    // Charger la liste des lots par id de vente
    load() {
      LotService.findBySaleId(this.$route.params.sale_id)
        .then(response => {
          this.lots = response.data;
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>
