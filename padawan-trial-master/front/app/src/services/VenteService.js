/* eslint-disable */
import axios from 'axios'

// Récupération de path de base à partir de variable d'environnement ROOT_API
const url = `${process.env.ROOT_API}/sales`;

class VenteService {
    /**
     * Récupération des ventes
     */
    getAll() {
        return axios.get(url);
    }
    /**
     * Méthode permet d'ajouter une nouvelle vente
     * @param vente Le nouveau Objet Vente
     */
    creerVente(vente) {
        return axios.post(url, vente);
    }
    /**
     * Rechercher des ventes par description (description contient le mot clé passé en paramètre)
     * @param description La description
     */
    rechercherVenteParDescription(description) {
        return axios.get(`${url}?description_like=${description}`);
    }

}

export default new VenteService();
