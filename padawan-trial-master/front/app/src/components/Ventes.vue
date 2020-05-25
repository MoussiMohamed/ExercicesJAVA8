<template>
<div align="center">
  <form @submit.prevent="add">
      <input type="text" v-model="form.title" placeholder="Titre" >
      <input type="text" v-model="form.description" placeholder="description" >

      <v-btn type="submit">
        Ajouter
      </v-btn>

  </form>
    <h1>Liste des Ventes</h1>
    <table border="1">
        <tr>
          <th>ID</th>
          <th>Titre</th>
          <th>Description</th>
        </tr>
        <tr v-for="vente in ventes" :key="vente.id">
          <td><span>{{vente.id}}</span> &#160;</td>
          <td><span>{{vente.title}}</span> &#160;</td>
          <td><span>{{vente.description}}</span> &#160;</td>
          <td>
            <!-- <v-icon @click="afficherLotsParIdVente(vente.id)">afficher lots</v-icon> -->
            <router-link :to="{ name: 'lots', params: { sale_id: vente.id }}">Afficher lots</router-link>
          </td>
        </tr>
      </table>
</div>
</template>

<script>
/* eslint-disable */ 
import axios from 'axios'
export default {
  name: 'Ventes',
  data () {
    return {
      msg: 'Liste des ventes',
      ventes: [],
      form: {
        id: '',
        title: '',
        description: ''
      }
    }
  },
  mounted() {
    this.load()
  },
  methods: {
    load(){
        axios.get('http://localhost:3000/sales').then(res => {
            this.ventes = res.data
        }).catch ((err) => {
            console.log(err);
        })
    },
    add(){
      // Validation manquante...
        axios.post('http://localhost:3000/sales/', this.form).then(res => {
          this.load()
          this.form.title = ''
          this.form.description = ''
        })
      }
    },
}
</script>
