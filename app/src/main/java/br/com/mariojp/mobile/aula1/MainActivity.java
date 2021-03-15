package br.com.mariojp.mobile.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

/**
 * Usando o Log para exibir no Logcat o ciclo de vida da Activity
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * onCreate()
     * Sua implementação é obrigatoria
     * É chamado pelo sistema para criar a Activity
     * A Activity é criada atravez dele e para ele é passado o estado (Bundle).
     * No método onCreate(), você executa a lógica básica de inicialização da Activity.
     * Isso deve acontecer somente uma vez durante todo o período que a Activity durar.
     * Boas praticas para sua implementação:
     * - vincular dados a listas
     * - associar a atividade a um ViewModel
     * - instanciar algumas variáveis com escopo de classe
     * Esse método recebe um parâmetro do tipo Bundle que contém o estado anteriormente salvo da Activity.
     * - Se a atividade nunca existiu, o valor do objeto Bundle será nulo.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ciclo de Vida","Ciclo de Vida - onCreate");

    }


    /**
     * onStart()
     * Quando a Activity insere o estado "Iniciado", o sistema invoca o metodo onStart.
     * A chamada onStart() torna a Activity visível ao usuário
     * Prepara a Activity para ir para o primeiro plano e se tornar interativa.
     *
     * Por exemplo, é nesse método que o Activity inicializa o código que mantém a IU.
     *
     * Assim como método onCreate(), o  método onStart() deve ser de rapida execução.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de Vida","Ciclo de Vida - onStart");

    }


    /**
     *
     * onResume()
     * Quando a Activity vem para o primeiro plano.
     * É nesse estado que o Activity interage com o usuário.
     * A Activity permanece nesse estado até que algo ou outra Activity tome o foco.
     *
     * Por exemplo, receber uma chamada telefônica, navegar pelo usuário para outra atividade ou desativar a tela do dispositivo.
     *
     * Quando ocorre um evento que to ma o foco e interrompe a Activity e o sistema chama o método onPause().
     *
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de Vida","Ciclo de Vida - onResume");
    }


    /**
     * onPause()
     * O sistema chama esse método como a primeira indicação de que o usuário está deixando sua Activity
     * Nem sempre signifique que a Activity esteja sendo destruída.
     * Isso indica que a atividade não está mais em primeiro plano
     * - ainda possa estar visível se o usuário estiver no modo de várias janelas.
     * - Use o método onPause() para pausar ou ajustar operações que não devem continuar.
     *
     * Há vários motivos pelos quais uma Activity  entrar nesse estado.
     * - Algum evento interromper a execução do Activity, Esse é o caso mais comum.
     * - No Android 7.0 (API de nível 24) ou mais recentes, diversos aplicativos operam no modo de várias janelas. Como só um dos aplicativos (janelas) tem foco a qualquer momento, o sistema pausa todos os outros aplicativos.
     * - Uma nova atividade semitransparente (como uma caixa de diálogo) é aberta. Enquanto a Activity estiver parcialmente visível, mas não for a Activity em foco, ela permanecerá pausada.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de Vida","Ciclo de Vida - onPause");

    }


    /**
     *
     * onStop()
     * Quando a Activity não estiver mais visível ao usuário o sistema invocará onStop().
     *
     * Por exemplo:
     * - quando outra Activity preenche a tela.
     * - quando a Activity parar de operar e estiver prestes a ser concluída.
     *
     * No método onStop(), o Activity liberará ou ajustará recursos desnecessários enquanto o Activity não estiver visível ao usuário.
     * Por exemplo:
     * - Activity poderá pausar animações ou alternar de atualizações de local mais específicas para as menos detalhadas.
     *
     * Use onStop() para realizar operações de desligamento de uso intensivo da CPU.
     * Por exemplo:
     * - Se você não encontrar um momento mais oportuno para salvar informações em um banco de dados, poderá fazer isso durante onStop().
     *
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de Vida","Ciclo de Vida - onStop");

    }


    /**
     * onDestroy()
     * Chamado antes de a Activity ser destruída. O sistema invoca esse metodo porque:
     *
     * - a Activity está sendo finalizada (pelo fato do usuário descartá-la completamente ou devido a finish() ser chamado na Activity);
     * - o Sistema está destruindo temporariamente a Activity devido a uma mudança na configuração (como a rotação do dispositivo ou o modo de várias janelas)
     *
     * Em vez de inserir lógica à sua atividade para determinar por que ela está sendo destruída,
     * use um objeto ViewModel para manter os dados de visualização relevante a ela.
     * Se a atividade for recriada devido a uma mudança na configuração, o ViewModel não precisará realizar nenhuma ação.
     * - Ela será preservada e fornecida à próxima instância da Activity.
     * - Se a Activity não for recriada, o ViewModel chamará o método onCleared(), em que ele pode limpar os dados necessários antes da destruição.
     *
     * É possível distinguir entre essas duas situações com o método isFinishing().
     *
     * Caso a atividade esteja sendo encerrada, onDestroy() será o metodo final recebido pela Activity.
     * Se onDestroy() for chamado como o resultado da mudança na configuração,
     * o sistema criará imediatamente uma nova instância de Activity e chamará onCreate() nessa instância na nova configuração.
     *
     * O onDestroy() liberarão todos os recursos ainda não liberados pelos metodos anteriores, como onStop().
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo de Vida","Ciclo de Vida - onDestroy");

    }


    /**
     * onRestart()
     *
     * Esse metodo é executado sempre que uma Activity esta no estado do onStop(), ou seja perdeu
     * completamente o foco e o usuario decidiu retornar a ela.
     *
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo de Vida","Ciclo de Vida - onRestart");

    }
}