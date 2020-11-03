package com.tech.observerExample

class MessagePublisher : Subject{

    private  var list : ArrayList<Observer> = ArrayList();
    override fun attach(o: Observer?) {
        if (o != null) {
            list.add(o)
        }
    }

    override fun detach(o: Observer?) {
        if (o != null) {
            list.remove(o)
        }
    }

    override fun notifyUpdate(m: Message?) {
        for (o in list) {
            o.update(m)
        }
    }
}