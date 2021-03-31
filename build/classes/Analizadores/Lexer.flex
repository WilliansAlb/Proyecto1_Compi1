package Analizadores;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%unicode
%line
%column
%char
%public
L=[a-zA-Z]+
L2 = [a-zA-ZÀ-ÿ\u00f1\u00d1]+
D=[0-9]+
DEC = [1-9][0-9]*["."]*[0-9]*
C=[@_"-"%#&:]+
C2=[@_%#&:]+
espacio=[\t|\r|\n]+
DARK = [Dd][Aa][Rr][Kk]
WHITE = [Ww][Hh][Ii][Tt][Ee]
BLUE = [Bb][Ll][Uu][Ee]
ini= [Ii][Nn][Ii]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd]
inis= [Ii][Nn][Ii]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd][Ee][Ss]
fin= [Ff][Ii][Nn]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd]
fins= [Ff][Ii][Nn]_[Ss][Oo][Ll][Ii][Cc][Ii][Tt][Uu][Dd][Ee][Ss]
fecha = [12][09]([9][0-9]|[012][0-9])"-"([0][1-9]|[1][0-2])"-"([0][1-9]|[1-2][0-9]|[3][01])
esp = [ ]+
%state CONSULTA
%state STRING
%state RESTRICCION
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* palabras reservadas */
<YYINITIAL> ":"                 {return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
<YYINITIAL> ","                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                 {return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}
<YYINITIAL> "}"                 {return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext());}
<YYINITIAL> "["                 {return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
<YYINITIAL> "]"                 {return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
<YYINITIAL> "\""                { yybegin(STRING); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
<YYINITIAL> "<!"                {return new Symbol(sym.INICIOE,yycolumn,yyline,yytext());}
<YYINITIAL> "!>"                {return new Symbol(sym.FINE,yycolumn,yyline,yytext());}
<YYINITIAL> "<"                 {return new Symbol(sym.MENORQ,yycolumn,yyline,yytext());}
<YYINITIAL> ">"                 {return new Symbol(sym.MAYORQ,yycolumn,yyline,yytext());}
<YYINITIAL> ({ini}":")          {return new Symbol(sym.INICIOS, yycolumn, yyline, yytext());}
<YYINITIAL> {fin}               {return new Symbol(sym.FINS,yycolumn,yyline,yytext());}
<YYINITIAL> {inis}              {return new Symbol(sym.SOLICITUDESP, yycolumn, yyline, yytext());}
<YYINITIAL> {fins}              {return new Symbol(sym.FINSOLICITUDES, yycolumn, yyline, yytext());}

<STRING> {
    ("'"|"’")           {  yybegin(RESTRICCION); return new Symbol(sym.APOSTROFE, yycolumn, yyline, yytext());}
    ("\"")              {  yybegin(YYINITIAL); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext()); }
    "|"                 {return new Symbol(sym.OR,yycolumn,yyline,yytext());}
    "CREAR_USUARIO"     {return new Symbol(sym.CREARU,yycolumn,yyline,yytext());}
    "USUARIO"           {return new Symbol(sym.USUARIOP,yycolumn,yyline,yytext());}
    "PASSWORD"          {return new Symbol(sym.CONTRAP,yycolumn,yyline,yytext());}
    "FECHA_CREACION"    {return new Symbol(sym.FECHACP,yycolumn,yyline,yytext());}
    "MODIFICAR_USUARIO" {return new Symbol(sym.MODIFICARU,yycolumn,yyline,yytext());}
    "USUARIO_ANTIGUO"   {return new Symbol(sym.USUARIOAP,yycolumn,yyline,yytext());}
    "USUARIO_NUEVO"     {return new Symbol(sym.USUARIONP,yycolumn,yyline,yytext());}
    "NUEVO_PASSWORD"    {return new Symbol(sym.NUEVOP,yycolumn,yyline,yytext());}
    "FECHA_MODIFICACION" {return new Symbol(sym.FECHAMP,yycolumn,yyline,yytext());}
    "ELIMINAR_USUARIO"  {return new Symbol(sym.ELIMINARU,yycolumn,yyline,yytext());}
    "LOGIN_USUARIO"     {return new Symbol(sym.LOGINU,yycolumn,yyline,yytext());}
    "NUEVO_FORMULARIO"  {return new Symbol(sym.NUEVOFP,yycolumn,yyline,yytext());}
    "ID"                {return new Symbol(sym.IDP,yycolumn,yyline,yytext());}
    "TITULO"            {return new Symbol(sym.TITULOP,yycolumn,yyline,yytext());}
    "NOMBRE"            {return new Symbol(sym.NOMBREP,yycolumn,yyline,yytext());}
    "TEMA"              {return new Symbol(sym.TEMAP,yycolumn,yyline,yytext());}
    "SELECT TO FORM"   { yybegin(CONSULTA); return new Symbol(sym.SELECT,yycolumn,yyline,yytext());}
    "USUARIO_CREACION"  {return new Symbol(sym.USUARIOCP,yycolumn,yyline,yytext());}
    ({DARK}|{WHITE}|{BLUE})   {return new Symbol(sym.TEMA,yycolumn,yyline,yytext());}
    ("CENTRO"|"IZQUIERDA"|"DERECHA"|"JUSTIFICAR")                       {return new Symbol(sym.ALINEA,yycolumn,yyline,yytext());}
    ("CAMPO_TEXTO"|"FICHERO")                                           {return new Symbol(sym.CLASENORMAL,yycolumn,yyline,yytext());}
    "AREA_TEXTO"                                                        {return new Symbol(sym.CLASEAREA,yycolumn,yyline,yytext());}
    ("CHECKBOX"|"RADIO"|"COMBO")                                        {return new Symbol(sym.CLASEOPCIONES,yycolumn,yyline,yytext());}
    "IMAGEN"                                                            {return new Symbol(sym.CLASEIMAGEN,yycolumn,yyline,yytext());}
    "BOTON"                                                             {return new Symbol(sym.CLASEBOTON,yycolumn,yyline,yytext());}
    "SI"|"NO"                                                           {return new Symbol(sym.BOOL,yycolumn,yyline,yytext());}
    "ELIMINAR_FORMULARIO"                                               {return new Symbol(sym.ELIMINARF,yycolumn,yyline,yytext());}
    "MODIFICAR_FORMULARIO"                                              {return new Symbol(sym.MODIFICARF,yycolumn,yyline,yytext());}
    "PARAMETROS_FORMULARIO"                                             {return new Symbol(sym.PARAMF,yycolumn,yyline,yytext());}
    "AGREGAR_COMPONENTE"                                                {return new Symbol(sym.AGREGARC,yycolumn,yyline,yytext());}
    "NOMBRE_CAMPO"      {return new Symbol(sym.NOMBREC,yycolumn,yyline,yytext());}
    "FORMULARIO"        {return new Symbol(sym.FORMULARIOC,yycolumn,yyline,yytext());}
    "CLASE"             {return new Symbol(sym.CLASE,yycolumn,yyline,yytext());}
    "INDICE"            {return new Symbol(sym.INDICEC,yycolumn,yyline,yytext());}
    "TEXTO_VISIBLE"     {return new Symbol(sym.TEXTOVC,yycolumn,yyline,yytext());}
    "ALINEACION"        {return new Symbol(sym.ALINEAC,yycolumn,yyline,yytext());}
    "REQUERIDO"         {return new Symbol(sym.REQUERIDO,yycolumn,yyline,yytext());}
    "OPCIONES"          {return new Symbol(sym.OPCIONES,yycolumn,yyline,yytext());}
    "FILAS"             {return new Symbol(sym.FILAS,yycolumn,yyline,yytext());}
    "COLUMNAS"          {return new Symbol(sym.COLUMNAS,yycolumn,yyline,yytext());}
    "URL"               {return new Symbol(sym.URLC,yycolumn,yyline,yytext());}
    "ELIMINAR_COMPONENTE"                                               {return new Symbol(sym.ELIMINARC,yycolumn,yyline,yytext());}
    "PARAMETROS_COMPONENTE"                                             {return new Symbol(sym.PARAMC,yycolumn,yyline,yytext());}
    "MODIFICAR_COMPONENTE"                                              {return new Symbol(sym.MODIFICARC,yycolumn,yyline,yytext());}
    "CREDENCIALES_USUARIO"                                              {return new Symbol(sym.CREDENCIALES,yycolumn,yyline,yytext());}
    "CONSULTAR_DATOS"                                                   {return new Symbol(sym.CONSULTARD,yycolumn,yyline,yytext());}
    "CONSULTAS"                                                         {return new Symbol(sym.CONSULTASP,yycolumn,yyline,yytext());}
    ("CONSULTA-"{D})                                                    {return new Symbol(sym.NOCONSULTA,yycolumn,yyline,yytext());}
    {D}                      {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {fecha} {return new Symbol(sym.FECHA,yycolumn,yyline,yytext());}
    ({L}|{D}|{C})+ {return new Symbol(sym.USUARIO,yycolumn,yyline,yytext());}
    ("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})* {return new Symbol(sym.ID,yycolumn,yyline,yytext());}
    ("https://")?{L}({L})*"."{L}({L})*".com/"(({L}|{D}|{C})*("/")?)* {return new Symbol(sym.URL, yycolumn,yyline,yytext());}
    ({L}|{D})(({esp}|"-")*({L}|{D}|{C2}|{L2}))* {return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
}
<CONSULTA> {
    ("\"")              { yybegin(YYINITIAL); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext()); }
    "["                 {yybegin(RESTRICCION); return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
    ","                                                                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    "WHERE"                                                             {return new Symbol(sym.WHERE,yycolumn,yyline,yytext());}
    "->"                                                                {return new Symbol(sym.DE,yycolumn,yyline,yytext());}
    ({L}|{D}|{C})+                                                      {return new Symbol(sym.USUARIO,yycolumn,yyline,yytext());}
    ("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})*                                 {return new Symbol(sym.ID,yycolumn,yyline,yytext());}
    {espacio}           {/*Ignore*/}
    {esp}               {/*Ignore*/}
}
<RESTRICCION> {
    ("'"|"’")                    { yybegin(STRING); return new Symbol(sym.APOSTROFE, yycolumn, yyline, yytext());}
    "]"                          { yybegin(CONSULTA);return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
    ","                                                                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    {D}                                                                 {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {DEC}                                                               {return new Symbol(sym.DEC, yycolumn,yyline,yytext());}
    "NOT"                                                               {return new Symbol(sym.NOT,yycolumn,yyline,yytext());}
    "AND"                                                               {return new Symbol(sym.AND,yycolumn,yyline,yytext());}
    "OR"                                                                {return new Symbol(sym.OROP,yycolumn,yyline,yytext());}
    "="                                                                 {return new Symbol(sym.IGUAL,yycolumn,yyline,yytext());}
    ">="                                                                {return new Symbol(sym.MAYORIGUAL,yycolumn,yyline,yytext());}
    ">"                                                                 {return new Symbol(sym.MAYORQ,yycolumn,yyline,yytext());}
    "<"                                                                 {return new Symbol(sym.MENORQ,yycolumn,yyline,yytext());}
    "<="                                                                {return new Symbol(sym.MENORIGUAL,yycolumn,yyline,yytext());}
    "->"                                                                {return new Symbol(sym.DE,yycolumn,yyline,yytext());}
    "("                                                                 {return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
    ")"                                                                 {return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
    ({L}|{D}|{C})+                                                      {return new Symbol(sym.USUARIO,yycolumn,yyline,yytext());}
    ("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})*                                 {return new Symbol(sym.ID,yycolumn,yyline,yytext());}
    {espacio}           {/*Ignore*/}
    {esp}               {/*Ignore*/}
}
    ({L}|{D}|{C})+              {return new Symbol(sym.USUARIO,yycolumn,yyline,yytext());}
{esp} {/*ignore*/}
{espacio}           {/*Ignore*/}
/* error fallback */
    .                              { return new Symbol(sym.ERRORLEX,yycolumn,yyline,yytext()); }
