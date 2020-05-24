<template>
<div align="center">
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
            <v-icon @click="edit(vente)">create</v-icon>
            <v-icon @click="del(vente)">delete</v-icon>
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
      ventes: ''
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
        // axios.get('http://localhost:3000/departamentos').then(res => {
        //     this.departamentos = res.data
        // }).catch ((err) => {
        //     console.log(err);
        // })
    }
  }
}
</script>
