var a = 1;

function somar (param1, param2){
    return (param1 + param2);
}

function mostrarMensagem(){
    var minhaSenha = document.getElementById("senha").value;
    console.log( minhaSenha ) ;

    if(minhaSenha == "123456" && minhaSenha.length > 1){
        alert( "senha padrão" );
    }
    else{
        document.getElementById("usuário").value = minhaSenha;
        alert( minhaSenha.toUpperCase() + "estou concatenando uma string")
    } 
    
    var meuArray = [ 1,2,3,4,5,6 ];
    somar( 2 , 5 );
}

  var s = somar (1 , 2);
  console.log ( s );