/* eslint-disable */
import axios from 'axios'

// Récupération de path de base à partir de variable d'environnement ROOT_API
const url = `${process.env.ROOT_API}/items`;

class LotService {
    /**
    * Récupération de la liste des lots par vente
    */
    findBySaleId(sale_id) {
        return axios.get(`${url}?sale_id=${sale_id}`);
    }
    /**
    * Récupération des lots
    */
   getAll() {
        return axios.get(url);
    }
    /**
     * Méthode permet d'ajouter un nouveau Lot
     * @param lot Le nouveau Objet Lot
     */
    creerLot(lot) {
        return axios.post(url, lot);
    }
    /**
     * Rechercher des lots par description
     * @param description Le mot clé de description
     */
    rechercherVenteParDescription(description) {
        return axios.get(`${url}?description_like=${description}`);
    }
}

export default new LotService();
