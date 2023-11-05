    #Create global variables

    set ns [new Simulator]

     

    #setting nam trace

    set namf [open wired1.nam w]

    $ns namtrace-all $namf

     

    #open the trace file

    set tracef [open wired1.tr w]

    $ns trace-all $tracef

    set proto rlm

     

    #setting the color values

    $ns color 1 blue

    $ns color 2 yellow

    $ns color 3 red

     

    #———- creating client- router- end server node—————-#

    set n0 [$ns node]

    set n1 [$ns node]

    set n2 [$ns node]

     

    #establish the link between the nodes

    $ns duplex-link $n0 $n1 2Mb 100ms DropTail

    $ns duplex-link $n1 $n2 200Kb 100ms DropTail

     

    #Label the nodes

    $ns at 0.0 “$n0 label Client1”

    $ns at 0.0 “$n1 label Server”

    $ns at 0.0 “$n2 label Client2”

     

    #setting the color for nodes

    $n0 color blue

    $n1 color red

    $n2 add-mark pradeep green square

     

    #Shaping the nodes for differentiation

    $n1 shape hexagon

    $n2 shape square

     

    #finish procedure

    proc finish {} {

    global ns tracefnamf

    $ns flush-trace

    close $tracef

    close $namf

    puts “Opening nam…”

    exec nam wired1.nam &

    exit 0

    }

     

    #Calling finish procedure

    $ns at 2.0 “finish”

    $ns run
