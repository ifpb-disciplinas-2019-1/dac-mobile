import { Component, OnInit } from '@angular/core';
import { Contato } from '../domain/contato';
import { NavController, NavParams, ToastController } from '@ionic/angular';
import { ContatosService } from '../contatos.service';

@Component({
  selector: 'app-contatos-list',
  templateUrl: './contatos-list.page.html',
  styleUrls: ['./contatos-list.page.scss'],
})
export class ContatosListPage implements OnInit {

  private contatos: Contato[];
  // constructor() { }

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              private service: ContatosService) {
 }

  ngOnInit() {
  this.service.todosOsContatos()
  .then( (dados: Contato[]) => {
    this.contatos = dados;
  }).catch(error => {
    // let tem = this.toast.create( {
    //     message: 'Servidor indisponivel',
    //     duration:3000,
    //     position:'top'
    //   }
    // );
    // tem.present();
  })

}
}
