<template>
  <v-app>
    <v-container fluid>
      <div align="center">
        <v-data-table :headers="headers" :items="lots" sort-by="description" class="elevation-1">
          <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>Liste des lots</v-toolbar-title>
              <v-divider class="mx-4" inset vertical></v-divider>
              <router-link to="/">Retour</router-link>
              <v-divider class="mx-4" inset vertical></v-divider>
              <v-spacer></v-spacer>
              <v-dialog v-model="dialog" max-width="500px">
                <template v-slot:activator="{ on }">
                  <v-btn color="primary" dark class="mb-2" v-on="on">Nouveau</v-btn>
                </template>
                <v-card>
                  <v-card-title>
                    <span class="headline">Ajouter un nouveau lot pour la vente:</span>
                    <span cols-12>
                      <strong>{{ titreVente }}</strong>
                    </span>
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field
                            v-model="nouveauLot.description"
                            required
                            label="Description"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">Annuler</v-btn>
                    <v-btn color="blue darken-1" text @click="creerLot">Ajouter</v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-toolbar>
          </template>
          <template v-slot:no-data>
            <v-alert :value="true" color="error">Sorry, nothing to display here :(</v-alert>
          </template>
        </v-data-table>
      </div>
    </v-container>
  </v-app>
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
      headers: [{ text: "Description", align: "left", value: "description" }],
      lots: [],
      sale_id: "",
      titleVente: "",
      dialog: false,
      editedIndex: -1,
      nouveauLot: {
        description: ""
      },
      nouveauLotParDefaut: {
        description: ""
      }
    };
  },
  created() {
    this.sale_id = this.$route.params.sale_id;
    this.titreVente = this.$route.params.title;
    this.nouveauLot.sale_id = this.sale_id;
    this.load();
  },
  methods: {
    // Charger la liste des lots par id de vente
    load() {
      LotService.findBySaleId(this.sale_id)
        .then(response => {
          this.lots = response.data;
        })
        .catch(err => {
          console.log(err);
        });
    },

    editItem(item) {
      this.editedIndex = this.lots.indexOf(item);
      this.nouveauLot = Object.assign({}, item);
      this.dialog = true;
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.nouveauLot = Object.assign({}, this.nouveauLotParDefaut);
        this.editedIndex = -1;
      });
    },

    creerLot() {
      if (this.editedIndex > -1) {
        Object.assign(this.lots[this.editedIndex], this.nouveauLot);
      } else {
        LotService.creerLot(this.nouveauLot)
          .then(response => {
            this.load();
          })
          .catch(err => {
            console.log(err);
          });
      }
      this.close();
    }
  }
};
</script>
