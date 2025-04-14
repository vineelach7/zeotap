BYTE_SIZE     : DIGIT+ ('.' DIGIT+)? BYTE_UNIT ;
TIME_DURATION : DIGIT+ ('.' DIGIT+)? TIME_UNIT ;

fragment BYTE_UNIT : [KkMmGg][Bb] ;
fragment TIME_UNIT : ('ms' | 's' | 'sec' | 'seconds') ;
fragment DIGIT     : [0-9] ;
