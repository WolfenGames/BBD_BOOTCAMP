using System;

namespace delegates_and_events {
    class PublishEvent
    {
        public event EventHandler<EventArgs>HandleEvent = delegate { };

        public void Run() {
            HandleEvent(this, new EventArgs());
        }
    }
}