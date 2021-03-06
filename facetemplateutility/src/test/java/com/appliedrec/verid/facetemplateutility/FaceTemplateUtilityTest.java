package com.appliedrec.verid.facetemplateutility;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@SuppressWarnings({"unchecked", "deprecated"})
public class FaceTemplateUtilityTest {

    private TestFaceTemplate[][] testFaceTemplates = {
        {
            new TestFaceTemplate("PdeWy70aox09peyvvCKJ0L4LZjI97inwvGrHED3TEve+Rhf2PcoLTz0/4rI9Jw2kvZPdX70g2GG8vH/TORB6gD1pFaE+HXWCvYN/f7yJtMI8EHqAvUaocLyT3V+9g39/PY+hyT3Xlss9Yb9ovYN/fz3TEve9+7VsPY+hyb3lIkc9xYd7PYN/f71wa9q+SpvKvh11grv81mE9Yb9ovh+3bLu0mSA+H7dsPTmtb72qcIM9LULoPVQz7LzQ0Q098q3EPaXsr72zeCu8ibTCu5B6gD2c5Qc9WvmqPVr5qr2zeCs9WvmqvWG/aL1hv2g+BuJevgkkSL2YYTM6EHqAPSDYYb28f9O9rvRXvSDYYT1hv2g9Jw2kPOZDPD4NqBw9oWjbu1i3wLxYt8A+H7dsvDSZILuQeoA9P+KyvemmG70aox08ibTCOpB6gL0g2GG9P+KyPcEDp74tQug8ascQvNDRDb4P6ga+Q9YMPcoLTz4EoHQ98q3EPH8YS705rW89CbTCu7SZIDkQeoA+ABygPaFo2z1Nbi6+LULoPaXsr744jHo9CbTCPiH5Vj2Df38+FG3au7SZIDwQeoA9D1mLPgtmMj2haNu9h3LYPnD8VD0U/lS9Yb9ovVr5qju0mSC8ascQPQQP+b3TEvc9k91fvbx/073cGp++BKB0vYN/fz1/GEs=", new float[]{0.10526808351278305f, -0.037753213196992874f, 0.081017844378948212f, -0.0099205523729324341f, -0.13613203167915344f, 0.11629092693328857f, -0.014329686760902405f, 0.10306351631879807f, -0.19345077872276306f, 0.098654381930828094f, 0.046847052872180939f, 0.040784493088722229f, -0.07219957560300827f, -0.039268855005502701f, -0.023010170087218285f, 0.00013778544962406158f, 0.056905392557382584f, 0.15376856923103333f, -0.064208023250102997f, -0.016809824854135513f, 0.0088182687759399414f, -0.048500478267669678f, -0.018049893900752068f, -0.064208023250102997f, 0.070132799446582794f, 0.10526808351278305f, 0.055114179849624634f, -0.064208023250102997f, 0.10306351631879807f, -0.12290462851524353f, 0.070132799446582794f, -0.11188178509473801f, 0.096449814736843109f, 0.064208023250102997f, -0.058696605265140533f, -0.19785991311073303f, -0.15376856923103333f, -0.007715985644608736f, 0.055114179849624634f, -0.15597313642501831f, -0.0055114179849624634f, 0.15597313642501831f, 0.045331414788961411f, -0.083222411572933197f, 0.042300134897232056f, 0.051807329058647156f, -0.025490308180451393f, 0.11849549412727356f, 0.081017844378948212f, -0.087631545960903168f, -0.016809824854135513f, -0.0044091343879699707f, 0.076608709990978241f, 0.053460754454135895f, 0.053460754454135895f, -0.087631545960903168f, 0.053460754454135895f, -0.055114179849624634f, -0.055114179849624634f, 0.13172289729118347f, -0.13392746448516846f, -0.074404142796993256f, 0.00055114179849624634f, 0.039268855005502701f, -0.092040680348873138f, -0.085426978766918182f, -0.039268855005502701f, 0.055114179849624634f, 0.040784493088722229f, 0.028108231723308563f, 0.13833659887313843f, 0.078813277184963226f, -0.003306850790977478f, -0.013227403163909912f, 0.15597313642501831f, -0.011022835969924927f, -0.0044091343879699707f, 0.046847052872180939f, -0.11408635228872299f, -0.037753213196992874f, 0.016809824854135513f, 0.0011022835969924927f, -0.039268855005502701f, -0.046847052872180939f, 0.094245247542858124f, -0.16920053958892822f, 0.014329686760902405f, -0.025490308180451393f, -0.14054116606712341f, -0.19124621152877808f, 0.098654381930828094f, 0.12951833009719849f, 0.11849549412727356f, 0.015569756738841534f, -0.045331414788961411f, 0.033619649708271027f, -0.0055114179849624634f, 0.00013778544962406158f, 0.12510919570922852f, 0.078813277184963226f, 0.050153903663158417f, -0.16920053958892822f, 0.081017844378948212f, -0.18022337555885315f, 0.033619649708271027f, 0.1581777036190033f, 0.064208023250102997f, 0.14495030045509338f, -0.0055114179849624634f, 0.0088182687759399414f, 0.034997504204511642f, 0.13613203167915344f, 0.078813277184963226f, -0.066137015819549561f, 0.23533755540847778f, 0.036375358700752258f, -0.055114179849624634f, -0.053460754454135895f, 0.0055114179849624634f, -0.014329686760902405f, 0.032241795212030411f, -0.10306351631879807f, 0.07219957560300827f, -0.092040680348873138f, -0.10747265070676804f, -0.12951833009719849f, -0.064208023250102997f, 0.062279026955366135f}),
            new TestFaceTemplate("u25lWL2AMyo9hDw3PYxOUL27fQk91FJCvUVr7bwe7jq9aW3mPc9a0L0RRcE+JcJ3vG5lWLz9S629CxBzvYhFQz2ZV9o+CnGFu8apyb0+l7A7nu46vVqHkLxuZVi82oeQO+5lWD4FehM9RWvtvegwCT2ip9C9cOERvG5lWL27fQk+AIKhPIxOULzw4RG9/A3RvP1LrT1pbeY9toWXviDLBTyXexA+GVfavDLMAr2ZV9o5Hu46u+5lWDxuZVg9nf/VPi01or22hZc9TEApPP1LrT2d/9W6nu46PZCm074H9cy8uQFQvG5lWLwe7jo+Y9eGvM9a0L1Fa+28RqnJPRd7EL4H9cw9EUXBvOW0UD0XexC8oqfQPQTbJT4quek9eFQ7vM9a0L0LEHM+NKjMvAsQcz2U/1c9cOERvgztPr27fQm98h7tPRFFwTwyzAK+GVfaPcVr7b40qMw8z1rQvYQ8N71pbea9CxBzPcVr7T22hZc+AIKhPIxOUL14VDs9eFQ7vOW0UL0XexA99xZfPbt9Cb0RRcG+I0a+Pg9o9748G/e9PpewPhvTkz14VDs+LTWiPNqHkD0qGvu8jE5QPi+xWz4H9cy9PpewPoSLrrzw4RG9CxBzO+5lWL2IRUM8Hu46vIxOUL2EPDc9/A3RvaKn0L38DdG+G9OTvWH6uz2AMyo=", new float[]{-0.003637632355093956f, -0.062597587704658508f, 0.064567975699901581f, 0.068508744239807129f, -0.091547079384326935f, 0.10367251932621002f, -0.048198629170656204f, -0.0097003523260354996f, -0.056989572942256927f, 0.10124742984771729f, -0.035466913133859634f, 0.16187463700771332f, -0.014550529420375824f, -0.030919874086976051f, -0.033951234072446823f, -0.066538356244564056f, 0.074874594807624817f, 0.13519866764545441f, -0.0060627204366028309f, -0.046531379222869873f, 0.0048501761630177498f, -0.053351938724517822f, -0.014550529420375824f, -0.026675969362258911f, 0.007275264710187912f, 0.13034848868846893f, 0.048198629170656204f, -0.11337286978960037f, 0.079421639442443848f, -0.05880839005112648f, -0.014550529420375824f, -0.091547079384326935f, 0.12549830973148346f, 0.017127186059951782f, -0.02940419502556324f, -0.12307322770357132f, -0.030919874086976051f, 0.056989572942256927f, 0.089121989905834198f, -0.15702445805072784f, 0.018491297960281372f, 0.14974918961524963f, -0.010912897065281868f, -0.074874594807624817f, 0.00015156800509430468f, -0.007275264710187912f, 0.014550529420375824f, 0.077148117125034332f, 0.16914990544319153f, -0.089121989905834198f, 0.049865875393152237f, 0.030919874086976051f, 0.077148117125034332f, -0.0012125440407544374f, 0.070630691945552826f, -0.13277357816696167f, -0.022583633661270142f, -0.014550529420375824f, -0.0097003523260354996f, 0.22250184416770935f, -0.025311857461929321f, -0.048198629170656204f, -0.012125440873205662f, 0.036982595920562744f, -0.13277357816696167f, 0.035466913133859634f, -0.028040081262588501f, 0.036982595920562744f, -0.019855409860610962f, 0.032435555011034012f, 0.16672481596469879f, 0.060627203434705734f, -0.025311857461929321f, -0.033951234072446823f, 0.17642515897750854f, -0.0084878085181117058f, 0.07275264710187912f, 0.05880839005112648f, -0.13762375712394714f, -0.091547079384326935f, -0.11822304874658585f, 0.035466913133859634f, 0.010912897065281868f, -0.14974918961524963f, 0.096397258341312408f, -0.17642515897750854f, 0.025311857461929321f, -0.064567975699901581f, -0.056989572942256927f, -0.033951234072446823f, 0.096397258341312408f, 0.089121989905834198f, 0.12549830973148346f, 0.017127186059951782f, -0.060627203434705734f, 0.060627203434705734f, -0.028040081262588501f, -0.036982595920562744f, 0.12064813822507858f, 0.091547079384326935f, -0.035466913133859634f, -0.15944954752922058f, 0.14004884660243988f, -0.18370042741298676f, -0.046531379222869873f, 0.15217427909374237f, 0.060627203434705734f, 0.16914990544319153f, 0.026675969362258911f, 0.041529636830091476f, -0.017127186059951782f, 0.17157499492168427f, 0.13277357816696167f, -0.046531379222869873f, 0.25887817144393921f, -0.02940419502556324f, -0.033951234072446823f, 0.007275264710187912f, -0.066538356244564056f, 0.0097003523260354996f, -0.017127186059951782f, -0.064567975699901581f, 0.12307322770357132f, -0.079421639442443848f, -0.12307322770357132f, -0.15217427909374237f, -0.055170755833387375f, 0.062597587704658508f})
        },
        {
            new TestFaceTemplate("PIfCur1ejve9+CcVPT0suDuOb/q8udYYPDIL+DsOb/o7+UP1PV6O9z2arZm9gaPrvMPZ+L1Khzc9EuN6vaOUmT4+2Ai8+UP1PjO3SLzD2fg8w9n4vXRCBr4E+oo9sO8ZvCA9+TzD2fg87iM2vjpkiLoOb/q90BeXvWXKpj3QF5c+IelJvTDvGT3Y/pc92P6XvQfCuj4mXMk9AjJavQ1TGj3CvRi9udYYvR6SqT4HNEq7+UP1PaOUmT21Ypg970AWPNfht7yHwro87iM2vWXKpj2arZk7sgv4PeZZFr4QG0q9nyEZu1Wn970Hwro+bZTGPY2aUr2NmlK9JLF5PRhz2j4E+oq9qAgZvfyalT3mWRY9ZcqmvMPZ+D0w7xk93XIXvQIyWr1RNHc96syWPbnWGDwgPfm7Vaf3vA5v+r21Ypg+BzRKPbVimD21Ypi9mq2ZPhkCSr4q0Em9hYj6vfOzlr0ksXk9GHPaPT0suL3zs5a+OCrIPYGj672Jbgo+FI7KvPlD9Tx7fbU+FsiKPVfht70ekqm9/JqVPGd19rwOb/o9ZcqmvOMCdr34JxU+CW4Kve9AFjsOb/o8w9n4PgCHCzzjAna+BzRKPax7mbz5Q/W9PSy4vQfCur4ddcm9vkmYPY2aUr3qzJa95lkWvZHGmr4mXMm9JLF5ve9AFr10QgY=", new float[]{0.016572345048189163f, -0.054335560649633408f, -0.12116829305887222f, 0.046185225248336792f, 0.0043468447402119637f, -0.02268509566783905f, 0.010867111384868622f, 0.0021734223701059818f, 0.0076069780625402927f, 0.054335560649633408f, 0.075526423752307892f, -0.063300929963588715f, -0.023907646536827087f, -0.049445357173681259f, 0.035861469805240631f, -0.079873271286487579f, 0.18637096881866455f, -0.030427912250161171f, 0.17550384998321533f, -0.023907646536827087f, 0.023907646536827087f, -0.059633277356624603f, -0.129861980676651f, 0.086393542587757111f, -0.0097804004326462746f, 0.023907646536827087f, 0.029069524258375168f, -0.18202412128448486f, -0.00054335559252649546f, -0.10160749405622482f, -0.056101463735103607f, 0.10160749405622482f, 0.15811647474765778f, -0.043196771293878555f, 0.10595434159040451f, 0.10595434159040451f, -0.033144690096378326f, 0.16246332228183746f, 0.031786300241947174f, -0.034503079950809479f, 0.095087230205535889f, -0.090740382671356201f, -0.038714084774255753f, 0.13203540444374084f, -0.0076069780625402927f, 0.079873271286487579f, 0.088566958904266357f, 0.11682145297527313f, 0.026352746412158012f, -0.016572345048189163f, 0.029069524258375168f, -0.056101463735103607f, 0.075526423752307892f, 0.0054335556924343109f, 0.11247460544109344f, -0.14072909951210022f, -0.077699847519397736f, -0.0032601335551589727f, -0.033144690096378326f, 0.23201283812522888f, 0.069141998887062073f, -0.069141998887062073f, -0.04020831361413002f, 0.037219859659671783f, 0.129861980676651f, -0.082046695053577423f, -0.12334171682596207f, 0.11247460544109344f, 0.056101463735103607f, -0.023907646536827087f, 0.043196771293878555f, 0.10812776535749435f, -0.031786300241947174f, -0.051075424998998642f, 0.11464802920818329f, 0.090740382671356201f, 0.0097804004326462746f, -0.0032601335551589727f, -0.0086936894804239273f, -0.088566958904266357f, 0.13203540444374084f, 0.088566958904266357f, 0.088566958904266357f, -0.075526423752307892f, 0.14942279458045959f, -0.16681016981601715f, -0.065202668309211731f, -0.11899487674236298f, -0.04020831361413002f, 0.037219859659671783f, 0.046185225248336792f, -0.11899487674236298f, -0.17985069751739502f, 0.063300929963588715f, -0.067104414105415344f, 0.14507594704627991f, -0.030427912250161171f, 0.015349795110523701f, 0.14724937081336975f, 0.052705492824316025f, -0.038714084774255753f, -0.12334171682596207f, 0.014127245172858238f, -0.0086936894804239273f, 0.056101463735103607f, -0.027711134403944016f, -0.12116829305887222f, 0.13420882821083069f, -0.11682145297527313f, 0.0021734223701059818f, 0.023907646536827087f, 0.12551514804363251f, 0.027711134403944016f, -0.13203540444374084f, 0.084220118820667267f, -0.030427912250161171f, -0.046185225248336792f, -0.033144690096378326f, -0.15376962721347809f, -0.092913806438446045f, 0.069141998887062073f, -0.11464802920818329f, -0.11247460544109344f, -0.071179583668708801f, -0.16246332228183746f, -0.04020831361413002f, -0.11682145297527313f, -0.059633277356624603f}),
            new TestFaceTemplate("PDLdg71Ff0G93lbpPG58r7zanPY8uRNtu258rztufK+7Hv3KPYRJKT38Jn++FurnvYxcDL0dv888uRNtvWmEwT3Kdy+9kLT9PiDaw71anPY6Hv3Kvaynmb3tPrQ9iFKbvP1kejxGvT09mWbevoSYqDyBLjS9/CZ/vVMpED3Ah1M+UA4bvIEuND2it709xX9BvAseET4g2sM9MQCKvZC0/T0+qlm9wIdTO258rz3ZXvq8z28ePZ4PTT2IUps+DPsKvIxcDDz9ZHo9Cx4RvReJ5T40un08bnyvPehGxb3ZXvq9eGyMvZ4PTbzlys4+Q6JIPgMLLr2QtP28Mt2DPPD4pj4Ajza9u49kvbaXdj3UZww9Hb/PPFqc9r2nr6s9ore9vIEuNLvufK8+BYclPM9vHjz9ZHq7nv3KvYRJKb1phME+D3cBO579yj0qK6K9TFQpPehGxb3ZXvq9tpd2vgp/E72xn4i8ore9PUxUKb4vwo6+I1a7PXD4przlys4+Cn8TvVqc9j1w+KY+Furnu+58r7yMXAy9u49kO+58r73Ah1M9eGyMPM9vHr3Ah1M9z28evhHy+T031XI91GcMPiDawz14bIy+BYclPSP1uLz9ZHq8Mt2DvDLdg73eVum9tpd2PYxcDL2nr6u98jaivgp/E740un28/WR6vXhsjDyXieU=", new float[]{0.01091707032173872f, -0.048217061907052994f, -0.10856420546770096f, 0.014556094072759151f, -0.026686172932386398f, 0.022592270746827126f, -0.0036390235181897879f, 0.0036390235181897879f, -0.0024260156787931919f, 0.064592666923999786f, 0.12312030047178268f, -0.14738045632839203f, -0.068534940481185913f, -0.038513001054525375f, 0.022592270746827126f, -0.057011369615793228f, 0.098860137164592743f, -0.070657707750797272f, 0.15708450973033905f, -0.053372345864772797f, 0.00060650391969829798f, -0.084304042160511017f, -0.11584225296974182f, 0.066563807427883148f, -0.030931700021028519f, 0.012130078859627247f, 0.074903234839439392f, -0.25897717475891113f, 0.015769101679325104f, -0.12312030047178268f, -0.051552832126617432f, 0.094008110463619232f, 0.20317880809307098f, -0.015769101679325104f, 0.079452015459537506f, 0.096434123814105988f, -0.0084910551086068153f, 0.15708450973033905f, 0.043213404715061188f, -0.070657707750797272f, 0.046549174934625626f, -0.094008110463619232f, 0.0036390235181897879f, 0.10613818466663361f, -0.025321539491415024f, 0.077177621424198151f, 0.066563807427883148f, 0.13767638802528381f, -0.017133735120296478f, 0.030931700021028519f, 0.033964220434427261f, -0.036996740847826004f, 0.17649264633655548f, 0.014556094072759151f, 0.11341623216867447f, -0.10613818466663361f, -0.06065039336681366f, -0.077177621424198151f, -0.028050806373357773f, 0.19104874134063721f, 0.12797233462333679f, -0.070657707750797272f, -0.01091707032173872f, 0.029415439814329147f, 0.12554630637168884f, -0.09158208966255188f, -0.089156076312065125f, 0.10371217131614685f, 0.038513001054525375f, 0.013343086466193199f, -0.081878028810024261f, 0.079452015459537506f, -0.015769101679325104f, -0.0072780470363795757f, 0.13039834797382355f, 0.025321539491415024f, 0.030931700021028519f, -0.0048520313575863838f, -0.064592666923999786f, -0.057011369615793228f, 0.14010240137577057f, 0.0048520313575863838f, 0.04154551774263382f, -0.049884948879480362f, 0.11341623216867447f, -0.10613818466663361f, -0.089156076312065125f, -0.13525037467479706f, -0.086730062961578369f, -0.019863003864884377f, 0.049884948879480362f, -0.17164060473442078f, -0.159510537981987f, 0.058830879628658295f, -0.028050806373357773f, 0.13525037467479706f, -0.053372345864772797f, 0.058830879628658295f, 0.14738045632839203f, -0.0072780470363795757f, -0.017133735120296478f, -0.09158208966255188f, 0.0072780470363795757f, -0.094008110463619232f, 0.06065039336681366f, 0.025321539491415024f, -0.094008110463619232f, 0.1012861579656601f, -0.14252842962741852f, 0.044881291687488556f, 0.10371217131614685f, 0.15708450973033905f, 0.06065039336681366f, -0.13039834797382355f, 0.040029257535934448f, -0.030931700021028519f, -0.01091707032173872f, -0.01091707032173872f, -0.10856420546770096f, -0.089156076312065125f, 0.068534940481185913f, -0.081878028810024261f, -0.11826826632022858f, -0.13525037467479706f, -0.17649264633655548f, -0.030931700021028519f, -0.06065039336681366f, 0.018498370423913002f})
        }
    };

    private float similarityThreshold = 4.0f;

    @Test
    public void test_convertStringToFaceTemplate_succeeds() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                float[] template = faceTemplateUtility.faceTemplateFromString(faceTemplate.getString());
                assertArrayEquals(template, faceTemplate.getFaceTemplate(), 0.0001f);
            }
        }
    }

    @Test
    public void test_decodeFaceTemplateFromString_succeeds() {
        FaceTemplateBase64Coder coder = new FaceTemplateBase64Coder();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                float[] template = coder.decodeFaceTemplate(faceTemplate.getString());
                assertArrayEquals(template, faceTemplate.getFaceTemplate(), 0.0001f);
            }
        }
    }

    @Test
    public void test_convertFaceTemplateToString_succeeds() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                String string = faceTemplateUtility.stringFromFaceTemplate(faceTemplate.getFaceTemplate());
                assertEquals(faceTemplate.getString(), string);
            }
        }
    }

    @Test
    public void test_encodeFaceTemplateToString_suceeds() {
        FaceTemplateBase64Coder coder = new FaceTemplateBase64Coder();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                String string = coder.encodeFaceTemplate(faceTemplate.getFaceTemplate());
                assertEquals(faceTemplate.getString(), string);
            }
        }
    }

    @Test
    public void test_convertFaceTemplateToStringWithSpecifiedBase64Coder_succeeds() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.withBase64(FaceTemplateUtility.DEFAULT_BASE_64);
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                String string = faceTemplateUtility.stringFromFaceTemplate(faceTemplate.getFaceTemplate());
                assertEquals(faceTemplate.getString(), string);
            }
        }
    }

    @Test
    public void test_convertFaceTemplateToStringWithSpecifiedStringCoder_succeeds() {
        FaceTemplateUtility<String> faceTemplateUtility = FaceTemplateUtility.withCoder(new FaceTemplateBase64Coder());
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                String string = faceTemplateUtility.getFaceTemplateCoder().encodeFaceTemplate(faceTemplate.getFaceTemplate());
                assertEquals(faceTemplate.getString(), string);
            }
        }
    }

    @Test
    public void test_compareSameUser_returnsHighScore() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (int i=0; i<testFaceTemplate.length-1; i++) {
                float score = faceTemplateUtility.compareFaceTemplates(testFaceTemplate[i].getFaceTemplate(), testFaceTemplate[i+1].getFaceTemplate());
                assertTrue(score > similarityThreshold);
            }
        }
    }

    @Test
    public void test_compareStringTemplatesOfSameUser_returnsHighScore() {
        FaceTemplateUtility<String> faceTemplateUtility = FaceTemplateUtility.withCoder(new FaceTemplateBase64Coder());
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (int i=0; i<testFaceTemplate.length-1; i++) {
                float score = faceTemplateUtility.compareFaceTemplates(testFaceTemplate[i].getString(), testFaceTemplate[i+1].getString());
                assertTrue(score > similarityThreshold);
            }
        }
    }

    @Test
    public void test_compareDifferentUsers_returnsLowScore() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance();
        for (int i=0; i<testFaceTemplates.length-1; i++) {
            TestFaceTemplate[] user1Templates = testFaceTemplates[i];
            TestFaceTemplate[] user2Templates = testFaceTemplates[i+1];
            for (TestFaceTemplate template1 : user1Templates) {
                for (TestFaceTemplate template2 : user2Templates) {
                    float score = faceTemplateUtility.compareFaceTemplates(template1.getFaceTemplate(), template2.getFaceTemplate());
                    assertTrue(score < similarityThreshold);
                }
            }
        }
    }

    @Test
    public void test_getTemplateNorms_equalsOne() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (TestFaceTemplate faceTemplate : testFaceTemplate) {
                float norm = faceTemplateUtility.getFaceTemplateNorm(faceTemplate.getFaceTemplate());
                assertEquals(1f, norm, 0.0001f);
            }
        }
    }

    @Test
    public void test_getFakeTemplateNorms_doesNotEqualOne() {
        float[] template = new float[]{0.1f,1f,0f,0.4f,0.6f,0.9f};
        float norm = FaceTemplateUtility.defaultInstance().getFaceTemplateNorm(template);
        assertNotEquals(1f, norm, 0.0001f);
    }

    @Test
    public void test_compareSameUserWithUnitNorms_returnsHighScore() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.withUnitNorm();
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (int i=0; i<testFaceTemplate.length-1; i++) {
                float score = faceTemplateUtility.compareFaceTemplates(testFaceTemplate[i].getFaceTemplate(), testFaceTemplate[i+1].getFaceTemplate());
                assertTrue(score > similarityThreshold);
            }
        }
    }

    @Test
    public void test_compareSameUserWithSpecifiedStandardDeviation_returnsHighScore() {
        FaceTemplateUtility<float[]> faceTemplateUtility = FaceTemplateUtility.defaultInstance().setStandardDeviation(FaceTemplateUtility.DEFAULT_STANDARD_DEVIATION);
        for (TestFaceTemplate[] testFaceTemplate : testFaceTemplates) {
            for (int i=0; i<testFaceTemplate.length-1; i++) {
                float score = faceTemplateUtility.compareFaceTemplates(testFaceTemplate[i].getFaceTemplate(), testFaceTemplate[i+1].getFaceTemplate());
                assertTrue(score > similarityThreshold);
            }
        }
    }

    @Test
    public void test_createFaceTemplateUtilityWithStandardDeviation_succeeds() {
        float value = 2.0f;
        assertEquals(value, FaceTemplateUtility.withStandardDeviation(value).getStandardDeviation(), 0.0001f);
    }

    @Test
    public void test_setStandardDeviation_getValueEqualsSetValue() {
        float value = 2.0f;
        assertEquals(value, FaceTemplateUtility.defaultInstance().setStandardDeviation(value).getStandardDeviation(), 0.00001f);
    }

    @Test
    public void test_setBase64_outputMatchesImplementation() {
        final byte[] testData = new byte[]{0,1,2,3};
        final String testString = "fake";
        IBase64 fakeBase64Coder = new IBase64() {
            @Override
            public String encode(byte[] bytes) {
                return testString;
            }

            @Override
            public byte[] decode(String string) {
                return testData;
            }
        };
        assertArrayEquals(testData, FaceTemplateUtility.defaultInstance().setBase64(fakeBase64Coder).getBase64().decode(testString));
        assertEquals(testString, FaceTemplateUtility.defaultInstance().setBase64(fakeBase64Coder).getBase64().encode(testData));
    }

    @Test
    public void test_setNullBase64_usesDefault() {
        final byte[] testData = new byte[]{0,1,2,3};
        assertEquals(FaceTemplateUtility.defaultInstance().setBase64(null).getBase64().encode(testData), FaceTemplateUtility.DEFAULT_BASE_64.encode(testData));
    }

    @Test
    public void test_convertToFaceTemplate_succeeds() {
        FaceTemplateUtility<String> faceTemplateUtility = FaceTemplateUtility.withCoder(new FaceTemplateBase64Coder());
        for (TestFaceTemplate[] faceTemplates : testFaceTemplates) {
            for (TestFaceTemplate testFaceTemplate : faceTemplates) {
                float[] converted = faceTemplateUtility.getFaceTemplateCoder().decodeFaceTemplate(testFaceTemplate.getString());
                assertArrayEquals(testFaceTemplate.getFaceTemplate(), converted, 0.001f);
            }
        }
    }
}