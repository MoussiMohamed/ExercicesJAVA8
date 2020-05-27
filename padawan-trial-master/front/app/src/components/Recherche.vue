<template>
  <v-app>
    <v-card color="red lighten-2" dark>
      <v-card-title class="headline red lighten-3">
        <span>Recherche des ventes et des lots</span>
        <v-divider class="mx-4" inset vertical></v-divider>
        <v-spacer></v-spacer>
        <router-link to="/" class="white-text">Liste des ventes</router-link>
      </v-card-title>
      <v-card-title class="headline red lighten-3">Type : {{type}}</v-card-title>
      <v-card-text>
        <v-autocomplete
          v-model="model"
          :items="items"
          :loading="isLoading"
          :search-input.sync="search"
          color="white"
          hide-no-data
          hide-selected
          item-text="Description"
          item-value="description"
          placeholder="Rechercher"
          prepend-icon="mdi-database-search"
          return-object
        ></v-autocomplete>
      </v-card-text>
      <v-divider></v-divider>
      <v-expand-transition>
        <v-list v-if="model" class="red lighten-3">
          <v-list-item v-for="(field, i) in fields" :key="i">
            <v-list-item-content>
              <v-list-item-subtitle v-text="field.key"></v-list-item-subtitle>
              <v-list-item-title v-text="field.value"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-expand-transition>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn :disabled="!model" color="grey darken-3" @click="model = null; type = null">
          Effacer
          <v-icon right>mdi-close-circle</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
</template>

<script>
/* eslint-disable */
import axios from "axios";
import VenteService from "../services/VenteService";
import LotService from "../services/LotService";

export default {
  data: () => ({
    descriptionLimit: 60,
    entries: [],
    isLoading: false,
    model: null,
    search: null,
    type: ""
  }),

  computed: {
    fields() {
      if (!this.model) return [];
      this.type = this.model.type;
      delete this.model.type
      delete this.model.sale_id
      return Object.keys(this.model)
      .map(key => {
        return {
          key,
          value: this.model[key] || "n/a"
        };
      });
    },
    items() {
      return this.entries.map(entry => {
        if (entry.hasOwnProperty('title')) {
          entry.type = "Vente"
        } else {
          entry.type = "Lot"
        }
        const Description = entry.description;
        delete entry.description
        return Object.assign({}, entry, { Description });
      });
    }
  },

  watch: {
    search(val) {

      // Une requete en cours
      if (this.isLoading) return;

      this.isLoading = true;

      // Lazily load input items
      axios.all([VenteService.rechercherVenteParDescription(this.search), LotService.rechercherVenteParDescription(this.search)])
      .then(axios.spread((...responses) => {
        this.entries = (responses[0].data).concat(responses[1].data);
      })).catch(errors => {
        console.log(errors);
      })
      .finally(() => (this.isLoading = false));
    }
  }
};
</script>